package com.ezeeshop.dto;

public class ProductHelper {


	private Long productId;
	private String productName;
	private int productPrice;
	private int quantity;
	private String productImageUrl;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
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
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "ProductHelper [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", quantity=" + quantity + ", productImageUrl=" + productImageUrl + "]";
	}
	
	
	
	
}
