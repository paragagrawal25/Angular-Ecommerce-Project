
package com.ezeeshop.rest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.dao.ProductDAO;
import com.ezeeshop.entity.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDAO dao;

	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		Product product1 = new Product();

		product1.setProductName(product.getProductName());
		product1.setProductImageUrl(product.getProductImageUrl());
		product1.setProductPrice(product.getProductPrice());
		dao.save(product1);
	}

	@Transactional

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("productName") Long productId) {

		dao.deleteById(productId);
	}

	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product) {
		
		dao.save(product);

	}
}
