package com.fatima.metro_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic farePaymentTopic() {
        return new NewTopic("fare_payment", 1, (short) 1);
    }

    @Bean
    public NewTopic sosAlertTopic() {
        return new NewTopic("sos_alert", 1, (short) 1);
    }
}
