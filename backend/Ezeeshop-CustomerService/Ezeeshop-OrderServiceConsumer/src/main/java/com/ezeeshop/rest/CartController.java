package com.ezeeshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.dto.CartObject;
import com.ezeeshop.service.CartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins="*")
@Api(value="EzeeShop Cart Producer Service", description="Operations pertaining to Cart")
public class CartController {

	@Autowired
	private CartService service;
	
	
	
	@GetMapping("/cart")
	@ApiOperation(value = "Retrieving the cart associated with customerUserName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public CartObject getCart(@RequestParam String userName) throws CartExceptionClass
	{
		CartObject obj = service.getCart(userName);
		if(obj == null)
			throw new CartExceptionClass("No items in cart are available with customerUserName: "+ userName);
		else
			return obj;
	}
	
	
 
}
