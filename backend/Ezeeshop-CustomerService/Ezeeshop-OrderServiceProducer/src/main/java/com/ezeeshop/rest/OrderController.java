package com.ezeeshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.entity.ShippingDetails;
import com.ezeeshop.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins="*")
@Api(value="EzeeShop Order Producer Service", description="Operations pertaining to Order")
public class OrderController {

	@Autowired
	private OrderService service;

	@PostMapping("/orders")
	@ApiOperation(value = "Place Order associated with customerUserName")
	public ResponseEntity<String> placeOrder(@RequestBody ShippingDetails shippingDetails,
			@RequestParam String userName) {
		service.saveOrder(shippingDetails, userName);
		// cartService.deleteCart(userName);
		return ResponseEntity.status(HttpStatus.CREATED).body("Order Placed");
	}

	@PutMapping("/orders/{id}")
	@ApiOperation(value = "Cancel Order associated with customerUserName")
	public ResponseEntity<String> cancelOrder(@PathVariable("id") Long id) {
		service.cancelOrder(id);
		return ResponseEntity.status(HttpStatus.OK).body("Cancelled");
	}

}
