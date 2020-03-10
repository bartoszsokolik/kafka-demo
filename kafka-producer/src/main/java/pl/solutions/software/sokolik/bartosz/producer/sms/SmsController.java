package pl.solutions.software.sokolik.bartosz.producer.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.solutions.software.sokolik.bartosz.event.SendSmsEvent;
import pl.solutions.software.sokolik.bartosz.event.SendSmsRequest;
import pl.solutions.software.sokolik.bartosz.producer.sms.domain.SmsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sms")
class SmsController {

    private final SmsService smsService;

    @PostMapping
    ResponseEntity<Void> sendSms(@RequestBody SendSmsRequest event) {
        smsService.sendSmsEvent(event);
        return ResponseEntity.ok().build();
    }
}
