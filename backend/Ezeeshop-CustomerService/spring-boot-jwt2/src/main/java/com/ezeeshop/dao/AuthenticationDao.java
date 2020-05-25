package com.ezeeshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ezeeshop.model.Authenticate;

@Repository
public interface AuthenticationDao extends JpaRepository<Authenticate, Integer> {

	@Query
	public Authenticate findByUserName(String username);
}
