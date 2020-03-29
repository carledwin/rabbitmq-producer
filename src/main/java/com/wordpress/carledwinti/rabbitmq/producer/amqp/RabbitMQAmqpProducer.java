package com.wordpress.carledwinti.rabbitmq.producer.amqp;

import com.wordpress.carledwinti.rabbitmq.producer.dto.MessageDto;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQAmqpProducer implements AmqpProducer<MessageDto> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageDto messageDto) {

        try {

            rabbitTemplate.convertAndSend(this.exchange, this.queue, messageDto);
        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
