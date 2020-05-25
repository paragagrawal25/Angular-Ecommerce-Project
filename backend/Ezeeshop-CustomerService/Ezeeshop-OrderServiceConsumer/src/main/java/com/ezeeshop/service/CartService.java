package com.ezeeshop.service;

import com.ezeeshop.dto.CartObject;
import com.ezeeshop.entity.Cart;

public interface CartService {

	public void addToCart(Cart cart);
	public CartObject getCart(String customerUserName);
	public void deleteCart(String customerUserName);
	public void updateProductQuantity(Cart cart);
	
}
