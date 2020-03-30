package pl.solutions.software.sokolik.bartosz.event.correlation.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.internals.RecordHeader;
import pl.solutions.software.sokolik.bartosz.event.correlation.base.ThreadCorrelationId;

import java.util.Map;

public class EventProducerInterceptor implements ProducerInterceptor<String, Object> {

    private ThreadCorrelationId threadCorrelationId;

    @Override
    public ProducerRecord<String, Object> onSend(ProducerRecord<String, Object> record) {
        String correlationId = threadCorrelationId.getOrCreateCorrelationId();
        record.headers().add(new RecordHeader("correlation_id", correlationId.getBytes()));
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {
        threadCorrelationId = (ThreadCorrelationId) map.get(ThreadCorrelationId.class.getSimpleName());
    }
}
