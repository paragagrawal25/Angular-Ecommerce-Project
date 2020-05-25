package com.ezeeshop.service;

import com.ezeeshop.entity.Product;
import com.ezeeshop.entity.ProductCategory;

public interface ProductService
{
	public void addProduct(Product product);
	public void deleteProduct(Long id);
	public void addProductCategory(ProductCategory productCategory);
	public void deleteProductCategory(Long Id);
	// public Long getAllProductsCount();

}