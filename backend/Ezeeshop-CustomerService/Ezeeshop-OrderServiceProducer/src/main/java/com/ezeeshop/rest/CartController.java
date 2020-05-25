package com.ezeeshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.entity.Cart;
import com.ezeeshop.service.CartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins="*")
@Api(value="EzeeShop Cart Consumer Service", description="Operations pertaining to Cart")
public class CartController {

	@Autowired
	private CartService service;

	@PostMapping("/cart")
	@ApiOperation(value = "Adding the product to cart")
	private ResponseEntity<String> addtoCart(@RequestBody Cart cart) {
		service.addToCart(cart);
		return ResponseEntity.noContent().build();
	}


	@DeleteMapping("/cart/{username}")
	@ApiOperation(value = "To delete the cart associated with customerUserName")
	public ResponseEntity<String> deleteCart(@PathVariable("username") String userName) {
		service.deleteCart(userName);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted");
	}


	@PutMapping("/cart")
	@ApiOperation(value = "Updation on products of cart associated with customerUserName")
	public ResponseEntity<String> updateCart(@RequestBody Cart cart) {
		// System.out.println(cart);
		service.updateProductQuantity(cart);
		return ResponseEntity.status(HttpStatus.OK).body("Updated");
	}

}
