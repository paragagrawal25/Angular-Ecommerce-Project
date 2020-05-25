package com.ezeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.model.Product;
import com.ezeeshop.model.ProductCategory;
import com.ezeeshop.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins="*")
@Api(value="EzeeShop Product Producer Service", description="Operations pertaining to Products and Products Category")
public class ProductController
{
	@Autowired
	private ProductService service;
	
	@PutMapping("/products")
	@ApiOperation(value = "Update the Product Details")
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		service.addProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body("Product Details update pushed to queue");
	}
	
	@PostMapping("/products")
	@ApiOperation(value = "Add a Product")
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		service.addProduct(product);
		return ResponseEntity.status(HttpStatus.OK).body("Add Product pushed to queue");
	}
	
	@DeleteMapping("/products")
	@ApiOperation(value = "Delete a Product")
	public ResponseEntity<String> deleteProduct(@RequestParam Long productId)
	{
		service.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body("Delete product pushed to queue");
	}
	
	@PutMapping("/productsCategory")
	@ApiOperation(value = "Update the ProductCategory Details")
	public ResponseEntity<String> updateProductCategory(@RequestBody ProductCategory productCategory)
	{
		service.addProductCategory(productCategory);
		return ResponseEntity.status(HttpStatus.OK).body("Category details update pushed to queue");
	}
	
	@PostMapping("/productsCategory")
	@ApiOperation(value = "Add a ProductCategory")
	public ResponseEntity<String> addProductCategory(@RequestBody ProductCategory productCategory)
	{
		service.addProductCategory(productCategory);
		return ResponseEntity.status(HttpStatus.OK).body("Add Category pushed to queue");
	}
	
	@DeleteMapping("/productsCategory")
	@ApiOperation(value = "Delete a ProductCategory")
	public ResponseEntity<String> deleteProductCategory(@RequestParam Long productCategoryId)
	{
		service.deleteProductCategory(productCategoryId);
		return ResponseEntity.status(HttpStatus.OK).body("Delete category pushed to queue");
	}
	
}
