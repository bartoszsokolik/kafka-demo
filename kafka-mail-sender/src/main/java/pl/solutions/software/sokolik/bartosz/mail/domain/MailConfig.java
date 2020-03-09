package pl.solutions.software.sokolik.bartosz.mail.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MailConfig {

    @Bean
    MailEventHandler mailEventHandler() {
        return new MailEventHandler();
    }
}
