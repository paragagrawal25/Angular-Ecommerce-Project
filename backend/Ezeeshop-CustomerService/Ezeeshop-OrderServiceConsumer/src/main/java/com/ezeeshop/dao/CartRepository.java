package com.ezeeshop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ezeeshop.entity.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

	@Query
	public List<Cart> findByCustomerUserName(String userName);
	@Query
	public Cart findByCustomerUserNameAndProductId(String customerUserName,Long productId);
	
	@Query
	@Transactional
	public int deleteByCustomerUserName(String userName);
	@Query
	@Transactional
	public int deleteByCustomerUserNameAndProductId(String userName,Long productId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Cart c SET c.quantity =:quantity WHERE c.customerUserName =:username AND c.productId =:id")
	public void updateProduct(@Param("username")String customerUserName,@Param("id")Long productId,@Param("quantity")int quantity);
	
}
