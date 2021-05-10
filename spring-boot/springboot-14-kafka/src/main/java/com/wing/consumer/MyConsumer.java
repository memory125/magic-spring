package com.wing.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author memory125
 */
@Component
public class MyConsumer {
    //这里便是监听了wing，只要程序不停止就会持续消费！
    @KafkaListener(topics = "wing")
    public void listen(ConsumerRecord<?,String> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            System.out.println(message);
        }
    }
}