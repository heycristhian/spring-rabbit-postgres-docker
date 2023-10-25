package br.com.heycristhian.main.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbit.messaging1.exchange.name}")
    private String messaging1ExchangeName;

    @Value("${rabbit.messaging1.queue.name}")
    private String messaging1QueueName;

    @Value("${rabbit.messaging2.exchange.name}")
    private String messaging2ExchangeName;

    @Value("${rabbit.messaging2.queue.name}")
    private String messaging2QueueName;


    @Bean
    public DirectExchange messaging1Exchange() {
        return new DirectExchange(messaging1ExchangeName);
    }

    @Bean
    public Queue messaging1Queue() {
        return new Queue(messaging1QueueName, false);
    }

    @Bean
    public DirectExchange messaging2Exchange() {
        return new DirectExchange(messaging2ExchangeName);
    }

    @Bean
    public Queue messaging2Queue() {
        return new Queue(messaging2QueueName, false);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> initAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);

        return rabbitTemplate;
    }

    @Bean
    public Binding bindingMessaging1() {
        return BindingBuilder.bind(messaging1Queue())
                .to(messaging1Exchange())
                .with("");
    }

    @Bean
    public Binding bindingMessaging2() {
        return BindingBuilder.bind(messaging2Queue())
                .to(messaging2Exchange())
                .with("");
    }

}
