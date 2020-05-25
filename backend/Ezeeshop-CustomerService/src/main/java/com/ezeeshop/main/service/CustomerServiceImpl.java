package com.ezeeshop.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ezeeshop.main.dao.UserDao;
import com.ezeeshop.main.entity.User;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private UserDao dao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User addUser(User user) {
		String img = "src/assets/" + user.getCustomerImageUrl();
		user.setCustomerImageUrl(img);
		
		user.setCustomerPassword(passwordEncoder.encode(user.getCustomerPassword()));
		dao.save(user);
		return user;
	}

	@Override
	public User getUserById(String userName) {
		
		return dao.findByUserName(userName);
	}

	@Override
	public User updateCustomer(String userName, User user) {
		User objUser = dao.findByUserName(userName);
		if(objUser != null)
			return dao.save(user);
		return null;
	}

}
