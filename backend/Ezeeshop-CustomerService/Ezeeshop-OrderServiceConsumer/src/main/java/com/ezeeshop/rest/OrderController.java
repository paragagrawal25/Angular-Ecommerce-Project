package com.ezeeshop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezeeshop.entity.Order;
import com.ezeeshop.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins="*")
@Api(value="EzeeShop Order Consumer Service", description="Operations pertaining to Order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	
	
	@GetMapping("/ordersByUserName")
	@ApiOperation(value = "Retrieving the List of Orders associated with customerUserName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public ResponseEntity<List<Order>> getOrder(@RequestParam String userName) throws CartExceptionClass
	{
		List<Order> orderList = service.getOrderByUserName(userName);
		if(orderList.isEmpty())
			throw new CartExceptionClass("No orders available with customerUserName: "+ userName);
		else
		return ResponseEntity.status(HttpStatus.OK).body(orderList);
	}
	
	@GetMapping("/orders")
	@ApiOperation(value = "Retrieving Order with orderId associated with customerUserName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public ResponseEntity<Order> getOrderById(@RequestParam Long id) throws CartExceptionClass
	{
		Order order = service.getOrderById(id);
		if(order == null)
			throw new CartExceptionClass("No order available with Id: "+ id);
		else
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}
	
	@GetMapping("/all-orders")
	@ApiOperation(value = "Retrieving All Orders")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") 
			})
	public ResponseEntity<List<Order>> getOrders() 
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllOrders());
	}
}
