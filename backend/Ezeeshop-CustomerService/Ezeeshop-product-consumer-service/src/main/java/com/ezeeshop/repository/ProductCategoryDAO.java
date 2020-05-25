package com.ezeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ezeeshop.entity.ProductCategory;

@Repository
@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Long>
{
	
}