package com.ezeeshop.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.entity.Cart;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String EXCHANGE= "otp-exchange";
	
	
	@Override
	public void addToCart(Cart cart) {
		amqpTemplate.convertAndSend(EXCHANGE,"cart",cart);
	}
	
	@Override
	public void deleteCart(String customerUserName) {
		//dao.deleteByCustomerUserName(customerUserName);
		amqpTemplate.convertAndSend(EXCHANGE, "deleteCartByUserName", customerUserName);
	}
	@Override
	public void updateProductQuantity(Cart cart) {
	
		
		amqpTemplate.convertAndSend(EXCHANGE,"updateCart", cart);
	}

	

	

}
