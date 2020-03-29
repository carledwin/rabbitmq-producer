package com.wordpress.carledwinti.rabbitmq.producer.service;

import com.wordpress.carledwinti.rabbitmq.producer.amqp.AmqpProducer;
import com.wordpress.carledwinti.rabbitmq.producer.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements AmqpService {

    @Autowired
    private AmqpProducer<MessageDto> messageDtoAmqpProducer;

    @Override
    public void sendMessageToConsumer(MessageDto messageDto) {

        messageDtoAmqpProducer.producer(messageDto);
    }
}
