package pl.solutions.software.sokolik.bartosz.producer.sms.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import pl.solutions.software.sokolik.bartosz.event.SendSmsEvent;

@Slf4j
@RequiredArgsConstructor
public class SmsService {

    private final String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendSmsEvent(SendSmsEvent request) {
        try {
            log.info("Sending sms event {} to topic {}", request, topic);
            kafkaTemplate.send(topic, request);
        } catch (Exception e) {
            log.info("Unable to send sms request to kafka");
        }
    }

}
