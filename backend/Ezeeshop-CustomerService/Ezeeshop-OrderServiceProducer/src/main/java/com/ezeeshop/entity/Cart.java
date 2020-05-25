package com.ezeeshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Model Class of Cart Table")
public class Cart {
	
	@ApiModelProperty(notes = "Id of Cart")
	private Long CartId;
	
	@ApiModelProperty(notes = "Quantiy of product in Cart")
	private int quantity;
	
	@ApiModelProperty(notes = "ProductId of product in Cart")
	private Long productId;
	
	@ApiModelProperty(notes = "CustomerUserName to which cart is associated")
	private String customerUserName;
	public Long getCartId() {
		return CartId;
	}
	public void setCartId(Long cartId) {
		CartId = cartId;
	}
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
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	
	
	
	
	
	
	
}
