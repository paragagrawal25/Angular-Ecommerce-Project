package com.ezeeshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezeeshop.entity.Product;

@Repository
@CrossOrigin("*")
public interface ProductDAO extends JpaRepository<Product, Long>
{
	@Query
	Page<Product> findByCategory_Id(@RequestParam("id") Long id, Pageable pageable);
	
	@Query
	Page<Product> findByProductNameContaining(@RequestParam("name") String name, Pageable pageable);
}
