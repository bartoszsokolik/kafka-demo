package pl.solutions.software.sokolik.bartosz.producer.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.solutions.software.sokolik.bartosz.event.SendMailEvent;
import pl.solutions.software.sokolik.bartosz.event.SendMailRequest;
import pl.solutions.software.sokolik.bartosz.producer.mail.domain.MailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/mail")
public class MailController {

    private final MailService mailService;

    @PostMapping
    ResponseEntity<Void> createMailEvent(@RequestBody SendMailRequest request) {
        mailService.sendEmailEvent(request);
        return ResponseEntity.ok().build();
    }
}
