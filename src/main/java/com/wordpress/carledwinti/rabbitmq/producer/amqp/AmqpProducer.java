package com.wordpress.carledwinti.rabbitmq.producer.amqp;

public interface AmqpProducer<T> {

    void producer(T t);
}
