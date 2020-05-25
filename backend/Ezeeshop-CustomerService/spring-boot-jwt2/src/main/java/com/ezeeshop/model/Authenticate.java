package com.ezeeshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name="Customers")
@Entity
@Getter
@Setter
public class Authenticate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String userName;
	private String customerPassword;
	private String customerMobileNo;
	private String customerImageUrl;
	
	public Authenticate() {
		
	}

	public Authenticate(String customerName, String userName, String customerPassword, String customerMobileNo,
			String customerImageUrl) {
		super();
		this.customerName = customerName;
		this.userName = userName;
		this.customerPassword = customerPassword;
		this.customerMobileNo = customerMobileNo;
		this.customerImageUrl = customerImageUrl;
	}
}
