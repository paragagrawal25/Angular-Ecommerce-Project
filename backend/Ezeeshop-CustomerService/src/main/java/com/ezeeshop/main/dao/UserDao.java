package com.ezeeshop.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezeeshop.main.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> 
{
	@Query
	public User findByUserName(@RequestParam("username") String username);
	  
	  // @Query public void deleteByName(String name);
	 

}
