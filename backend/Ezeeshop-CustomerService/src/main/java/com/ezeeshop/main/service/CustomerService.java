package com.ezeeshop.main.service;

import com.ezeeshop.main.entity.User;

public interface CustomerService {

	public User addUser(User user);
	public User getUserById(String userName);
	public User updateCustomer(String userName, User user);
}
