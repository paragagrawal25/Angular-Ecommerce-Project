package com.ezeeshop.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.model.Product;
import com.ezeeshop.model.ProductCategory;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private String EXCHANGE= "products-exchange";
	private static final String ROUTING_ADDPRODUCTSCATEGORY_KEY = "add-productsCategory";
	private static final String ROUTING_ADDPRODUCTS_KEY = "add-products";
	private static final String ROUTING_DELETEPRODUCTSCATEGORY_KEY = "delete-productsCategory";
	private static final String ROUTING_DELETEPRODUCTS_KEY = "delete-products";
	
	
	
	
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		//product.setProductAddDate(LocalDate.now());

		amqpTemplate.convertAndSend(EXCHANGE, ROUTING_ADDPRODUCTS_KEY, product);;
	}

	

	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		amqpTemplate.convertAndSend(EXCHANGE, ROUTING_DELETEPRODUCTS_KEY, productId);
	}

	@Override
	public void addProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		amqpTemplate.convertAndSend(EXCHANGE, ROUTING_ADDPRODUCTSCATEGORY_KEY, productCategory);
	}

	

	@Override
	public void deleteProductCategory(Long productCategoryId) {
		// TODO Auto-generated method stub
		amqpTemplate.convertAndSend(EXCHANGE, ROUTING_DELETEPRODUCTSCATEGORY_KEY, productCategoryId);
	}
}
