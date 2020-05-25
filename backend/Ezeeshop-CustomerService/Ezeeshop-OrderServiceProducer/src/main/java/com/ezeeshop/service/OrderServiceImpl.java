package com.ezeeshop.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.entity.Order;
import com.ezeeshop.entity.ShippingDetails;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String EXCHANGE= "otp-exchange";
	private String ROUTING_KEY = "order";
	
	
	public void saveOrder(ShippingDetails shippingDetails,String customerUserName)
	{
		Order order = new Order();
		order.setCustomerUserName(customerUserName);
		order.setAddress(shippingDetails);
		amqpTemplate.convertAndSend(EXCHANGE,ROUTING_KEY,order);
	}
	
 
	@Override
	public void cancelOrder(Long orderId) {
		// TODO Auto-generated method stub
		amqpTemplate.convertAndSend(EXCHANGE, "cancelOrder", orderId);
	}

	

}
