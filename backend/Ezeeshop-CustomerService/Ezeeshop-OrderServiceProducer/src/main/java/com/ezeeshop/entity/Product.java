package com.ezeeshop.entity;

import java.util.ArrayList;
import java.util.List;


public class Product {

	
	private Long productId;
	private String productName;
	private Long productPrice;
	private int quantity;
	
	private List<Order> orders = new ArrayList<Order>();
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
