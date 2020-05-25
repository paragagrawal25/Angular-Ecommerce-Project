
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
public class RabbitMqConfig {

	private static final String ORDER_QUEUE = "order-queue";
	private static final String CANCELORDER_QUEUE = "cancelOrder-queue";
	private static final String CART_QUEUE = "cart-queue";
	private static final String DELETECARTBYUSERNAME_QUEUE = "deleteCartByUserName-queue";
	private static final String UPDATECARTBY_QUEUE = "updateCart-queue";
	private static final String EXCHANGE = "otp-exchange";
	private static final String ROUTING_ORDER_QUEUE = "order";
	private static final String ROUTING_CART_QUEUE = "cart";
	private static final String ROUTING_DELETECARTBYUSERNAME_QUEUE = "deleteCartByUserName";
	private static final String ROUTING_UPDATECART_QUEUE = "updateCart";
	private static final String ROUTING_CANCELORDER_QUEUE = "cancelOrder";
	
	@Bean
	Queue order_queue()
	{
		return new Queue(ORDER_QUEUE);
	}
	@Bean
	Queue cancelOrder_queue()
	{
		return new Queue(CANCELORDER_QUEUE);
	}
	@Bean
	Queue cart_queue()
	{
		return new Queue(CART_QUEUE);
	}
	
	@Bean
	Queue deleteCartByUserName_queue()
	{
		return new Queue(DELETECARTBYUSERNAME_QUEUE);
	}
	@Bean
	Queue updateCart_queue()
	{
		return new Queue(UPDATECARTBY_QUEUE);
	}
	
	@Bean
	DirectExchange directExchange()
	{
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	Binding orderBinding(DirectExchange exchange,Queue order_queue)
	{
		return BindingBuilder.bind(order_queue).to(exchange).with(ROUTING_ORDER_QUEUE);
	}
	
	@Bean
	Binding cancelOrderBinding(DirectExchange exchange,Queue cancelOrder_queue)
	{
		return BindingBuilder.bind(cancelOrder_queue).to(exchange).with(ROUTING_CANCELORDER_QUEUE);
	}
	@Bean
	Binding cartBinding(DirectExchange exchange,Queue cart_queue)
	{
		return BindingBuilder.bind(cart_queue).to(exchange).with(ROUTING_CART_QUEUE);
	}
	
	@Bean
	Binding deleteCartByUserNameBinding(DirectExchange exchange,Queue deleteCartByUserName_queue)
	{
		return BindingBuilder.bind(deleteCartByUserName_queue).to(exchange).with(ROUTING_DELETECARTBYUSERNAME_QUEUE);
	}
	
	@Bean
	Binding deleteCartByIDBinding(DirectExchange exchange,Queue updateCart_queue)
	{
		return BindingBuilder.bind(updateCart_queue).to(exchange).with(ROUTING_UPDATECART_QUEUE);
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