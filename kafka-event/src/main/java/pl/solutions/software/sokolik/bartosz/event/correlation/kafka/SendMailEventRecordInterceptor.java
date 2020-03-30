package pl.solutions.software.sokolik.bartosz.event.correlation.kafka;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.event.SendMailEvent;
import pl.solutions.software.sokolik.bartosz.event.correlation.base.ThreadCorrelationId;

@Component
public class SendMailEventRecordInterceptor extends AbstractEventRecordInterceptor<String, SendMailEvent> {

    public SendMailEventRecordInterceptor(ThreadCorrelationId threadCorrelationId) {
        super(threadCorrelationId);
    }
}
