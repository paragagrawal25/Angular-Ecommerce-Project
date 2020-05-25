package com.ezeeshop.model;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Model Class of Products")
public class Product
{
	@ApiModelProperty(notes = "Id of Product")
	private Long id;
	
	@ApiModelProperty(notes = "Name of Product")
	private String productName;
	
	@ApiModelProperty(notes = "Price of Product")
	private Double productPrice;
	
	@ApiModelProperty(notes = "Category_Id of Product")
	private Long categoryId;
	
	@ApiModelProperty(notes = "ImageUrl of Product")
	private String productImageUrl;
	
	@ApiModelProperty(notes = "AddDate of Product")
	private LocalDate productAddDate;
	
	@ApiModelProperty(notes = "Description of Product")
	private String productDescription;
	
	@ApiModelProperty(notes = "Rating of Product")
	private Float productRating;
	
	@ApiModelProperty(notes = "Category of Product")
	private ProductCategory productCategory;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	public LocalDate getProductAddDate() {
		return productAddDate;
	}
	public void setProductAddDate(LocalDate productAddDate) {
		this.productAddDate = productAddDate;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Float getProductRating() {
		return productRating;
	}
	public void setProductRating(Float productRating) {
		this.productRating = productRating;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	
	
}
