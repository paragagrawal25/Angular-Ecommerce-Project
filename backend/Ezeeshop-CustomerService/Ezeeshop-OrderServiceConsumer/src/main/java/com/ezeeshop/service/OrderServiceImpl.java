package com.ezeeshop.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.dao.OrderRepository;
import com.ezeeshop.dto.CartObject;
import com.ezeeshop.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository dao;
	@Autowired
	private CartService cartService;
	private static final String CANCELORDER_QUEUE = "cancelOrder-queue";
    private static final String QUEUE= "order-queue";
	

	@RabbitListener(queues = QUEUE)
	public void saveOrder(Order order) {
		System.out.println("Items Recieved: " + order);
		CartObject cart = cartService.getCart(order.getCustomerUserName());
		//System.out.println(cart.getProductList());
		if(cart != null)
		{
		order.setTotalAmount(cart.getTotalPrice());
		order.setOrderDate(LocalDate.now());
		order.setOrderStatus("Delivered");
		dao.placeOrder(order,order.getAddress(),cart.getProductList());
		cartService.deleteCart(order.getCustomerUserName());
		}
	}

	@Override
	public Order getOrderById(Long id) {
		// TODO Auto-generated method stub
	      return dao.getOderById(id);
	     
	    		
	}

	@Override
	public List<Order> getOrderByUserName(String userName) {
		// TODO Auto-generated method stub
		return dao.getOrderByUserName(userName);
	}

	@Override
	@RabbitListener(queues = CANCELORDER_QUEUE)
	public void cancelOrder(Long orderId) {
		// TODO Auto-generated method stub
		dao.cancelOrder(orderId);
	}
	
	@Override
	public List<Order> getAllOrders() {
		return dao.getAllOrders();
	}

}
