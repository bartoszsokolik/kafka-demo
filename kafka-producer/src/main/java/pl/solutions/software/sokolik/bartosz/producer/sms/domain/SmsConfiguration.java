package pl.solutions.software.sokolik.bartosz.producer.sms.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
class SmsConfiguration {

    private final String topic;

    public SmsConfiguration(@Value("${kafka.topic}") String topic) {
        this.topic = topic;
    }

    @Bean
    SmsService smsService(KafkaTemplate<String, Object> kafkaTemplate) {
        return new SmsService(topic, kafkaTemplate);
    }
}
