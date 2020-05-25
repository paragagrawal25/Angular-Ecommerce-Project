package com.ezeeshop.service;

import com.ezeeshop.entity.Cart;

public interface CartService {

	public void addToCart(Cart cart);
	public void deleteCart(String customerUserName);
	public void updateProductQuantity(Cart cart);
	
}
