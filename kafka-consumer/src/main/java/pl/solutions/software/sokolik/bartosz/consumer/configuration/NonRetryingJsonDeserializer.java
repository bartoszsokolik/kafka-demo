package pl.solutions.software.sokolik.bartosz.consumer.configuration;

import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Slf4j
public class NonRetryingJsonDeserializer<T> extends JsonDeserializer<T> {

    private final T nullObject;

    public NonRetryingJsonDeserializer(Class<T> targetType, T nullObject) {
        super(targetType, false);
        this.nullObject = nullObject;
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            return super.deserialize(topic, data);
        } catch (Exception e) {
            log.error("failed to deserialize message for topic {}: {}", topic, new String(data, StandardCharsets.UTF_8));
            return nullObject;
        }
    }
}
