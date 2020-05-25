package com.ezeeshop.dto;

import java.util.List;

import com.ezeeshop.entity.Product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="Model Class of Cart Helper")
public class CartObject {

	@ApiModelProperty(notes = "CustomerUserName to which cart is associated")
	private String customerUserName;
	
	@ApiModelProperty(notes = "List of product in CartHelper ")
	private List<Product> productList;
	
	@ApiModelProperty(notes = "TotalPrice of products in Cart")
	private int totalPrice;
	
	
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
