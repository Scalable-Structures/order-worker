package com.scalablestructures.orderworker.app.provider.queue.rabbitmq.config;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitmqConfig {
    @Value("${application.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${application.rabbitmq.queue.name}")
    private String queueName;

    @Bean
    Exchange declareExchange() {
        return ExchangeBuilder.directExchange(this.exchangeName)
            .durable(true)
            .build();
    }

    @Primary
    @Bean
    Queue declareQueue() {
        return QueueBuilder.durable(this.queueName)
            .withArgument("x-dead-letter-exchange", this.exchangeName)
            .withArgument("x-dead-letter-routing-key", this.queueName + ".dlq")
            .build();
    }

    @Primary
    @Bean
    Binding declareBindingQueue() {
        return BindingBuilder.bind(this.declareQueue())
            .to(this.declareExchange())
            .with(this.queueName)
            .noargs();
    }

    @Bean
    Queue declareDeadLetterQueue() {
        return QueueBuilder.durable(this.queueName + ".dlq")
            .build();
    }

    @Bean
    Binding declareBindingDeadLetterQueue() {
        return BindingBuilder.bind(this.declareDeadLetterQueue())
            .to(this.declareExchange())
            .with(this.queueName + ".dlq")
            .noargs();
    }

    @Bean
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer>
        prefetchRabbitListenerContainerFactory(ConnectionFactory rabbitConnectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory);
        factory.setPrefetchCount(100);
        return factory;
    }
}
