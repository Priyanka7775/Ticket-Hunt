package com.project.authentication.rabbitmq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MConfiguration {
    @Bean
    public Jackson2JsonMessageConverter getMessageProducer() {
        return new Jackson2JsonMessageConverter();
    }
}