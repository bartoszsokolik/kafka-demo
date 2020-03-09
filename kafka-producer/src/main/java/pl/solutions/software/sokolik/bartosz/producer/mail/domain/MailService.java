package pl.solutions.software.sokolik.bartosz.producer.mail.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import pl.solutions.software.sokolik.bartosz.event.SendMailEvent;

@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEmailEvent(SendMailEvent request) {
        try {
            log.info("Sending mail event {} to topic {}", request, topic);
            kafkaTemplate.send(topic, request);
        } catch (Exception e) {
            log.info("Unable to send mail request to kafka");
        }
    }
}
