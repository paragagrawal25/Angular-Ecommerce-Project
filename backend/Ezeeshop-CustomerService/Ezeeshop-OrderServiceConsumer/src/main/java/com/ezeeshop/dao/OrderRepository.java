package com.ezeeshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezeeshop.entity.Order;
import com.ezeeshop.entity.Product;
import com.ezeeshop.entity.ShippingDetails;

@Repository
public class OrderRepository {

	@Autowired
	private EntityManager em;
	
	public ShippingDetails getBillingAddress(Long id)
	{
		return em.find(ShippingDetails.class, id);
	}
	
	public List<Order> getOrderByUserName(String customerUserName)
	{
		TypedQuery<Order> query = em.createQuery("select o FROM Order o where o.customerUserName=:username", Order.class);
		query.setParameter("username", customerUserName);
		List<Order> list = query.getResultList();
		return list;
	}
	
	public Order getOderById(Long id)
	{
		return em.find(Order.class,id);
	}
	
	@Transactional
	public Order placeOrder(Order order, ShippingDetails shippingDetails, List<Product> products)
	{
		
		em.persist(shippingDetails);
		em.persist(order);
		System.out.println(products);
		order.setProduct(products);
		order.setAddress(shippingDetails);
		return getOderById(order.getOrderId());
		
		
	}
	@Transactional
	public void cancelOrder(Long id)
	{
		Order order = getOderById(id);
		if(order != null)
			order.setOrderStatus("Cancelled");
	}
	
	@Transactional
	public void deleteOrder(Long id)
	{
		Order order = getOderById(id);
		if(order != null)
			em.remove(order);
	}
	
	public List<Order> getAllOrders() {
		TypedQuery<Order> query = em.createQuery("select O from Order O",Order.class);
		return query.getResultList();
	}
}
