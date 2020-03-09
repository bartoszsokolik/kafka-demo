package pl.solutions.software.sokolik.bartosz.mail.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import pl.solutions.software.sokolik.bartosz.event.Event;

@Slf4j
public class MailEventHandler {

    @KafkaListener(topics = "${kafka.topic}", id = "${kafka.consumer-group-id}")
    public void handleEvent(Event event) {
        log.info("Received event of {} from kafka", event);
    }
}
