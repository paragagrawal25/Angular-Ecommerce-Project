package com.ezeeshop.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ezeeshop.dto.ProductHelper;
@FeignClient("order-consumer-service")
public interface OrderFeign {

	@PostMapping("/products")
	public void addProduct(@RequestBody ProductHelper product);
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("productName") Long productId);
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody ProductHelper product);
}
