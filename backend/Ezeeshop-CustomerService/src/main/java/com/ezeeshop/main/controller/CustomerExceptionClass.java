package com.ezeeshop.main.controller;

public class CustomerExceptionClass extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomerExceptionClass(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomerExceptionClass [message=" + message + "]";
	}
	
	

}
