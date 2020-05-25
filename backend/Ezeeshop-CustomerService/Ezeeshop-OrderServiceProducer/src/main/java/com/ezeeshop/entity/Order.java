package com.ezeeshop.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="Model Class of Order Table")
public class Order {
	@ApiModelProperty(notes = "Id of Order")
	private Long orderId;
	
	@ApiModelProperty(notes = "CustomerUserName to which Order is associated")
	private String customerUserName;
	
	@ApiModelProperty(notes = "OrderDate of Order")
	private LocalDate orderDate;
	
	@ApiModelProperty(notes = "OrderStatus of Order")
	private String orderStatus;
	
	@ApiModelProperty(notes = "Total amount of Order")
	private int totalAmount;

	@ApiModelProperty(notes = "Shipping Details to which order is shipped")
	private ShippingDetails address;
	
	@ApiModelProperty(notes = "List of products in particular Order")
	private List<Product> product = new ArrayList<Product>();

	
	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public void addProduct(Product product) {
		this.product.add(product);
	}

	public ShippingDetails getAddress() {
		return address;
	}

	public void setAddress(ShippingDetails address) {
		this.address = address;
	}
	
	
	
}
