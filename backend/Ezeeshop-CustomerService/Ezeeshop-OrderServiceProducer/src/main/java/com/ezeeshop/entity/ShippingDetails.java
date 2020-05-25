package com.ezeeshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Model Class of Shipping Address Table")
public class ShippingDetails {

	@ApiModelProperty(notes = "Id of Shipping details")
	private Long shippingId;
	
	@ApiModelProperty(notes = "firstName of customer to which order is shipped")
	private String firstName;
	
	@ApiModelProperty(notes = "Lastname of customer to which order is shipped")
	private String lastName;
	
	@ApiModelProperty(notes = "PhoneNo of customer to which order is shipped")
	private String phoneNo;
	
	@ApiModelProperty(notes = "Email of customer to which order is shipped")
	private String email;
	
	@ApiModelProperty(notes = "AddressLine1 of customer to which order is shipped")
	private String addressLine1;
	
	@ApiModelProperty(notes = "AddressLine2 of customer to which order is shipped")
	private String addressLine2;
	
	@ApiModelProperty(notes = "City of customer to which order is shipped")
	private String city;
	
	@ApiModelProperty(notes = "State of customer to which order is shipped")
	private String state;
	
	@ApiModelProperty(notes = "Country of customer to which order is shipped")
	private String country;
	
	@ApiModelProperty(notes = "ZipCode of customer to which order is shipped")
	private String zipCode;

	@ApiModelProperty(notes = "OrderDetails of customer to which order is shipped")
	private Order orders;
	
	public Long getShippingId() {
		return shippingId;
	}
	public void setShippingId(Long shippingId) {
		this.shippingId = shippingId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
}
