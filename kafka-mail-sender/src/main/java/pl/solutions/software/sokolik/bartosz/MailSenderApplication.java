package pl.solutions.software.sokolik.bartosz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.solutions.software.sokolik.bartosz.event.correlation.CorrelationIdConfig;

@Import({
        CorrelationIdConfig.class
})
@SpringBootApplication
public class MailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailSenderApplication.class, args);
    }
}
