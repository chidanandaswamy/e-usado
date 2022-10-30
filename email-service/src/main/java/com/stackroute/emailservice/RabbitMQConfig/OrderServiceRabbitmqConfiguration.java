package com.stackroute.emailservice.RabbitMQConfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceRabbitmqConfiguration {


    public static final String QUEUE = "Order_queue";
    public static final String EXCHANGE = "Order_exchange";
    public static final String ROUTING_KEY = "Order_routing key";


    @Bean
    public Queue Orderqueue(){
        return new Queue(QUEUE,false);
    }

    @Bean
    public DirectExchange eexchange(){

        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding bbinding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter cconverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate ttemplate(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(cconverter());
        return rabbitTemplate;
    }
}
