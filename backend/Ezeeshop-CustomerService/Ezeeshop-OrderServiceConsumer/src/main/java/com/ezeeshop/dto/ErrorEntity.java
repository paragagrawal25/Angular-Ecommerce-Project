package com.ezeeshop.dto;

public class ErrorEntity {

	private int errorCode;
	private String message;
	private long time;
	public ErrorEntity(int errorCode, String message, long time) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.time = time;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	
	
}
