package com.ezeeshop.service;

import java.util.List;

import com.ezeeshop.entity.Order;

public interface OrderService {

	public void saveOrder( Order order);
	public Order getOrderById(Long id);
	public List<Order> getOrderByUserName(String userName);
	public void cancelOrder(Long orderId);
	public List<Order> getAllOrders();
}

