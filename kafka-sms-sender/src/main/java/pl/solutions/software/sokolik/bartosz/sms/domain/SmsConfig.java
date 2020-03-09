package pl.solutions.software.sokolik.bartosz.sms.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SmsConfig {

    @Bean
    SmsEventHandler smsEventHandler() {
        return new SmsEventHandler();
    }
}
