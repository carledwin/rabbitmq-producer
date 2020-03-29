package com.wordpress.carledwinti.rabbitmq.producer.dto;

public class MessageDto {

    private String message;

    public MessageDto(){ }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "message='" + message + '\'' +
                '}';
    }
}
