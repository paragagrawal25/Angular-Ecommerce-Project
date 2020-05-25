package com.ezeeshop.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Model Class of Product_Category")
public class ProductCategory 
{
	@ApiModelProperty(notes = "Id of ProductCategory")
	private Integer productCategoryId;
	
	@ApiModelProperty(notes = "Name of ProductCategory")
	private String productCategoryName;
	
	@ApiModelProperty(notes = "List of Product in particular ProductCategory")
	private List<Product> productList = new ArrayList<>();
	
	
	public Integer getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public List<Product> getProduct() {
		return productList;
	}
	public void setProduct(List<Product> productList) {
		this.productList = productList;
	}
	public void addProduct(Product product)
	{
		this.productList.add(product);
	}
	
}
