package com.wordpress.carledwinti.rabbitmq.producer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerRabbitMQConfiguration {

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.deadletter.producer}")
    private String queueDeadLetter;

    @Bean
    public Queue queue(){

        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", exchange);
        args.put("x-dead-letter-routing-key", queueDeadLetter);
        return new Queue(queue, true, false, false, args);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue queueDeadLetter(){
        return new Queue(queueDeadLetter);
    }

    @Bean
    public Binding bindingQueue(){
        return BindingBuilder
                .bind(queue())
                .to(directExchange()).with(queue);
    }

    @Bean
    public Binding bindingQueueDeadLetter(){
        return BindingBuilder
                .bind(queueDeadLetter())
                .to(directExchange()).with(queueDeadLetter);
    }
}
