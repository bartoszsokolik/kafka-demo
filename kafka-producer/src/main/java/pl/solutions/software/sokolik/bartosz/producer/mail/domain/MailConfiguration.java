package pl.solutions.software.sokolik.bartosz.producer.mail.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
class MailConfiguration {

    private final String topic;

    public MailConfiguration(@Value("${kafka.topic}") String topic) {
        this.topic = topic;
    }

    @Bean
    MailService mailService(KafkaTemplate<String, Object> kafkaTemplate) {
        return new MailService(topic, kafkaTemplate);
    }
}
