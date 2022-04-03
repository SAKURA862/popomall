package com.main.shopping.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfig {

    // 交换机
    public static final String DELAYED_EXCHANGE_NAME = "order.delayed.exchange";
    // 队列
    public static final String DELAYED_QUEUE_NAME = "order.delayed.queue";
    // routingKey
    public static final String DELAYED_ROUTING_KEY = "order.delayed.routingkey";
    // 延迟时间
    public static final Integer DELAYED_TIME = 1000 * 60 * 10;
    // 持久化队列
    public static final boolean DURABLE = true;
    // 队列独占
    public static final boolean EXCLUSIVE = false;
    // 自动删除
    public static final boolean AUTO_DELETE = false;

    // 声明交换机（基于插件的交换机）
    @Bean
    public CustomExchange delayedExchange() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type", "direct");

        /**
         * 1. 交换机名字
         * 2. 交换机类型
         * 3. 是否需要持久化
         * 4. 是否需要自动删除
         * 5. 其他参数
         */
        return new CustomExchange(
                DELAYED_EXCHANGE_NAME,
                "x-delayed-message",
                true,
                false,
                arguments
        );
    }

    // 声明队列
    @Bean
    public Queue delayedQueue() {
        return new Queue(DELAYED_QUEUE_NAME, DURABLE, EXCLUSIVE, AUTO_DELETE);
    }

    // 绑定
    @Bean
    Binding delayedQueueBindingDelayedExchange(
            @Qualifier("delayedQueue") Queue delayedQueue,
            @Qualifier("delayedExchange") CustomExchange delayedExchange
    ) {
        return BindingBuilder
                .bind(delayedQueue)
                .to(delayedExchange)
                .with(DELAYED_ROUTING_KEY)
                .noargs();
    }
}