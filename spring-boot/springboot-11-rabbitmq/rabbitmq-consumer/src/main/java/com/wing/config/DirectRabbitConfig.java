package com.wing.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author memory125
 */
@Configuration
public class DirectRabbitConfig {

    //队列 起名：testQueue
    @Bean
    public Queue testQueue() {
        return new Queue("testQueue",true);
    }

    //Direct交换机 起名：testExchange
    @Bean
    DirectExchange testExchange() {
        return new DirectExchange("testExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testQueue()).to(testExchange()).with("testRouting");
    }
}