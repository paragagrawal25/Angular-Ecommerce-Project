package com.ezeeshop.service;

import com.ezeeshop.entity.ShippingDetails;

public interface OrderService {

	public void saveOrder( ShippingDetails shippingDetails,String userName);
	
	public void cancelOrder(Long orderId);
	
}

