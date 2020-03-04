package pl.solutions.software.sokolik.bartosz.consumer.mail.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import pl.solutions.software.sokolik.bartosz.event.SendMailRequest;

@Slf4j
public class MailEventHandler {

    @KafkaListener(topics = "${kafka.topic}", id = "${kafka.consumer-group-id}")
    public void handleEvent(SendMailRequest request) {
        log.info("Received event {} from kafka", request);
    }
}
