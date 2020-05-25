package com.ezeeshop.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.main.entity.User;
import com.ezeeshop.main.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value="EzeeShop Customer Service", description="Operations pertaining to Customer")
public class UserController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/test")
	public String test()
	{
		return "test....";
	}
	
	@PostMapping("/customer")
	@ApiOperation(value = "Adding customer to database")
	public User addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}

	@GetMapping("/customer")
	@ApiOperation(value = "Retrieving the details of customer by userName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public ResponseEntity<User> getUserById(@RequestParam String username) throws CustomerExceptionClass
	{
		User user = service.getUserById(username);
		if(user == null)
			throw new CustomerExceptionClass("No customer exists with this userName: "+username);
		else
			return ResponseEntity.status(HttpStatus.OK).body(user);
			
	}
	
	@PutMapping("/customer")
	@ApiOperation(value = "Updating the customer details")
	public ResponseEntity<User> updateCustomer(@RequestParam String username, @RequestBody User customer) throws CustomerExceptionClass
	{
		User user = service.updateCustomer(username, customer);
		if(user == null)
			throw new CustomerExceptionClass("No customer exists with this userName: "+username);
		else
			return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
