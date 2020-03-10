package pl.solutions.software.sokolik.bartosz.producer.mail.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import pl.solutions.software.sokolik.bartosz.event.SendMailEvent;
import pl.solutions.software.sokolik.bartosz.event.SendMailRequest;

@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendEmailEvent(SendMailRequest request) {
        try {
            log.info("Sending mail event {} to topic {}", request, topic);
            SendMailEvent event = new SendMailEvent().toBuilder()
                    .body(request.getBody())
                    .recipient(request.getRecipient())
                    .subject(request.getSubject()).build();
            kafkaTemplate.send(topic, event);
        } catch (Exception e) {
            log.info("Unable to send mail request to kafka");
        }
    }
}
