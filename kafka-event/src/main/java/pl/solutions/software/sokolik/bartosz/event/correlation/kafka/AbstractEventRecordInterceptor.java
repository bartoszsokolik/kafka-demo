package pl.solutions.software.sokolik.bartosz.event.correlation.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.RecordInterceptor;
import pl.solutions.software.sokolik.bartosz.event.correlation.base.ThreadCorrelationId;

import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public abstract class AbstractEventRecordInterceptor<K, V> implements RecordInterceptor<K, V> {

    private final ThreadCorrelationId threadCorrelationId;

    @Override
    public ConsumerRecord<K, V> intercept(ConsumerRecord<K, V> record) {
        setCorrelationId(record);
        return record;
    }

    private void setCorrelationId(ConsumerRecord<K, V> record) {
        StreamSupport.stream(record.headers().spliterator(), false)
                .filter(p -> "correlation_id".equals(p.key()))
                .map(p -> new String(p.value()))
                .findFirst()
                .map(p -> {
                    threadCorrelationId.setCorrelationId(p);
                    return p;
                }).orElseGet(threadCorrelationId::createNewCorrelationId);
    }
}
