package com.wordpress.carledwinti.rabbitmq.producer.service;

import com.wordpress.carledwinti.rabbitmq.producer.dto.MessageDto;
import org.springframework.stereotype.Service;

@Service
public interface AmqpService {

    void sendMessageToConsumer(MessageDto messageDto);
}
