package com.ezeeshop.service;

import java.time.LocalDate;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.dto.ProductHelper;
import com.ezeeshop.entity.Product;
import com.ezeeshop.entity.ProductCategory;
import com.ezeeshop.feign.OrderFeign;
import com.ezeeshop.repository.ProductCategoryDAO;
import com.ezeeshop.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService
{
	private ProductDAO dao;
	private ProductCategoryDAO catRepository;
	@Autowired
	private OrderFeign client;
	
	
   @Autowired
    public ProductServiceImpl(ProductDAO dao, ProductCategoryDAO catRepository) {
		super();
		this.dao = dao;
		this.catRepository = catRepository;
		
	}

	private static final String ADDPRODUCTSQUEUE = "add-products-queue";
	private static final String DELETEPRODUCTSQUEUE = "delete-products-queue";
	private static final String ADDPRODUCTSCATEGORYQUEUE = "add-productsCategory-queue";
	private static final String DELETEPRODUCTSCATEGORYQUEUE = "delete-productsCategory-queue";

	@Override
	@RabbitListener(queues = ADDPRODUCTSQUEUE )
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		product.setProductAddDate(LocalDate.now()); 
		ProductCategory category =
		catRepository.findById(product.getCategoryId()).get();
		product.setCategory(category); 
		Product product2 = dao.save(product);
		
		ProductHelper helper = new ProductHelper();
		helper.setProductId(product2.getId());
		helper.setProductImageUrl(product2.getProductImageUrl());
		helper.setProductName(product2.getProductName());
		helper.setProductPrice(product2.getProductPrice());
		System.out.println(helper);
		client.addProduct(helper);
		
	}

	@Override
	@RabbitListener(queues = DELETEPRODUCTSQUEUE )
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		dao.deleteById(id);
		// client.deleteProduct(id);
		
	}

	@Override
	@RabbitListener(queues =ADDPRODUCTSCATEGORYQUEUE )
	public void addProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		catRepository.save(productCategory);
	}

	@Override
	@RabbitListener(queues = DELETEPRODUCTSCATEGORYQUEUE)
	public void deleteProductCategory(Long Id) {
		// TODO Auto-generated method stub
		catRepository.deleteById(Id);
	}

	/*@Override
	public Long getAllProductsCount() {
		// TODO Auto-generated method stub
		System.out.println(dao.count());
		return dao.count();
	}*/
}
