package com.ezeeshop.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Table(name="Customers")
@Entity
@ApiModel(description="Model Class of Customer Table")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Id of Customer")
	private int customerId;
	
	@ApiModelProperty(notes = "Name of Customer")
	private String customerName;
	
	@ApiModelProperty(notes = "userName of Customer")
	private String userName;
	
	@ApiModelProperty(notes = "Password of Customer")
	private String customerPassword;
	
	@ApiModelProperty(notes = "Mobile No. of Customer")
	private String customerMobileNo;
	
	@ApiModelProperty(notes = "ImageUrl of Customer profile photo")
	private String customerImageUrl;
	
	public User() {
		
	}

	public User(String customerName, String userName, String customerPassword, String customerMobileNo,
			String customerImageUrl) {
		super();
		this.customerName = customerName;
		this.userName = userName;
		this.customerPassword = customerPassword;
		this.customerMobileNo = customerMobileNo;
		this.customerImageUrl = customerImageUrl;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getCustomerImageUrl() {
		return customerImageUrl;
	}

	public void setCustomerImageUrl(String customerImageUrl) {
		this.customerImageUrl = customerImageUrl;
	}

	@Override
	public String toString() {
		return "User [customerId=" + customerId + ", customerName=" + customerName + ", username=" + userName
				+ ", customerPassword=" + customerPassword + ", customerMobileNo=" + customerMobileNo
				+ ", customerImageUrl=" + customerImageUrl + "]";
	}
}
