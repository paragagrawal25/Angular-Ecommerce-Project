package com.ezeeshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezeeshop.dao.CartRepository;
import com.ezeeshop.dao.ProductDAO;
import com.ezeeshop.dto.CartObject;
import com.ezeeshop.entity.Cart;
import com.ezeeshop.entity.Product;

@Service
public class CartServiceImpl implements CartService{

	private CartRepository dao;
	
	@Autowired
	private ProductDAO productDao;
	private static final String QUEUE= "cart-queue";
	private static final String DELETECARTBYUSERNAME_QUEUE = "deleteCartByUserName-queue";
	private static final String UPDATECARTBY_QUEUE = "updateCart-queue";
	@Autowired
	public CartServiceImpl(CartRepository dao) {
		super();
		this.dao = dao;
		
		
	}
	@Override
	@RabbitListener(queues = QUEUE)
	public void addToCart(Cart cart) {
		Cart cart2 = dao.findByCustomerUserNameAndProductId(cart.getCustomerUserName(), cart.getProductId());
		if(cart2 != null)
		{
			// System.out.println(cart2);
			cart2.setQuantity(cart2.getQuantity() + 1);
			dao.save(cart2);
		}
		else
		{
			dao.save(cart);
		}
	}
	@Override
	public CartObject getCart(String customerUserName) {
		// TODO Auto-generated method stub
		List<Cart> cart = dao.findByCustomerUserName(customerUserName);
		
		if(cart.isEmpty())
			return null;
		else
		{
		CartObject obj = new CartObject(); 
		List<Product> productList = new ArrayList<Product>();
		int totalPrice = 0;
		for(Cart objCart : cart)
		{
			Product product = productDao.findById(objCart.getProductId()).get();
			product.setQuantity(objCart.getQuantity());
			totalPrice += product.getProductPrice()*objCart.getQuantity();
			productList.add(product);
			
		}
		obj.setCustomerUserName(customerUserName);
		obj.setProductList(productList);
		obj.setTotalPrice(totalPrice);
		return obj;
		}
	}
	
	@Override
	@RabbitListener(queues = DELETECARTBYUSERNAME_QUEUE)
	public void deleteCart(String customerUserName) {
		dao.deleteByCustomerUserName(customerUserName);
		
	}
	@Override
	@RabbitListener(queues = UPDATECARTBY_QUEUE)
	public void updateProductQuantity(Cart cart) {

		if(cart.getQuantity()==0)
			dao.deleteByCustomerUserNameAndProductId(cart.getCustomerUserName(), cart.getProductId());
		else
		dao.updateProduct(cart.getCustomerUserName(), cart.getProductId(), cart.getQuantity());
	}

	

	

}
