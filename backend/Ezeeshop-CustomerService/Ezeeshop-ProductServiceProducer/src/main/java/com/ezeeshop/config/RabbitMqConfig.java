package com.ezeeshop.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig
{

	private static final String ADDPRODUCTSQUEUE = "add-products-queue";
	private static final String DELETEPRODUCTSQUEUE = "delete-products-queue";
	private static final String ADDPRODUCTSCATEGORYQUEUE = "add-productsCategory-queue";
	private static final String DELETEPRODUCTSCATEGORYQUEUE = "delete-productsCategory-queue";
	private static final String EXCHANGE = "products-exchange";
	private static final String ROUTING_ADDPRODUCTSCATEGORY_QUEUE = "add-productsCategory";
	private static final String ROUTING_ADDPRODUCTS_QUEUE = "add-products";
	private static final String ROUTING_DELETEPRODUCTSCATEGORY_QUEUE = "delete-productsCategory";
	private static final String ROUTING_DELETEPRODUCTS_QUEUE = "delete-products";
	
	@Bean
	Queue addProductsQueue()
	{
		return new Queue(ADDPRODUCTSQUEUE);
	}

	@Bean
	Queue addCategoryQueue()
	{
		return new Queue(ADDPRODUCTSCATEGORYQUEUE);
	}
	@Bean
	Queue deleteProductsQueue()
	{
		return new Queue(DELETEPRODUCTSQUEUE);
	}

	@Bean
	Queue deleteCategoryQueue()
	{
		return new Queue(DELETEPRODUCTSCATEGORYQUEUE);
	}
	@Bean
	DirectExchange directExchange()
	{
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	Binding addProductsBinding(DirectExchange exchange,Queue addProductsQueue)
	{
		return BindingBuilder.bind(addProductsQueue).to(exchange).with(ROUTING_ADDPRODUCTS_QUEUE);
	}
	@Bean
	Binding addCategoryBinding(DirectExchange exchange,Queue addCategoryQueue)
	{
		return BindingBuilder.bind(addCategoryQueue).to(exchange).with(ROUTING_ADDPRODUCTSCATEGORY_QUEUE);
	}
	
	@Bean
	Binding deleteProductsBinding(DirectExchange exchange,Queue deleteProductsQueue)
	{
		return BindingBuilder.bind(deleteProductsQueue).to(exchange).with(ROUTING_DELETEPRODUCTS_QUEUE);
	}
	@Bean
	Binding deleteCategoryBinding(DirectExchange exchange,Queue deleteCategoryQueue)
	{
		return BindingBuilder.bind(deleteCategoryQueue).to(exchange).with(ROUTING_DELETEPRODUCTSCATEGORY_QUEUE);
	}
	@Bean
	MessageConverter jsonMessageConverter()
	{
		return new Jackson2JsonMessageConverter();
	}
	@Bean
	AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
	{
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
