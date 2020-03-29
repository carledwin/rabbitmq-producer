package com.wordpress.carledwinti.rabbitmq.producer.api;

import com.wordpress.carledwinti.rabbitmq.producer.dto.MessageDto;
import com.wordpress.carledwinti.rabbitmq.producer.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpApi {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send (@RequestBody MessageDto messageDto){
        rabbitMQService.sendMessageToConsumer(messageDto);
    }

}
