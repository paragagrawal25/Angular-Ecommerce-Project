package com.ezeeshop.service;

import com.ezeeshop.model.Product;
import com.ezeeshop.model.ProductCategory;

public interface ProductService {

	public void addProduct(Product product);
	public void deleteProduct(Long productId);
	public void addProductCategory(ProductCategory productCategory);
	public void deleteProductCategory(Long productCategoryId);
	
}
