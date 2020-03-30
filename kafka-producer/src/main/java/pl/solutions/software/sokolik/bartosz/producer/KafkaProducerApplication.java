package pl.solutions.software.sokolik.bartosz.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.solutions.software.sokolik.bartosz.event.correlation.CorrelationIdConfig;

@Import({
        CorrelationIdConfig.class
})
@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
