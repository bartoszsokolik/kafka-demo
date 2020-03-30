package pl.solutions.software.sokolik.bartosz.producer.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import pl.solutions.software.sokolik.bartosz.event.correlation.base.ThreadCorrelationId;
import pl.solutions.software.sokolik.bartosz.event.correlation.kafka.EventProducerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private final String bootstrapServers;

    public KafkaConfig(@Value("${kafka.bootstrap-servers}") String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory(ThreadCorrelationId threadCorrelationId) {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProps.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, EventProducerInterceptor.class.getName());
        configProps.put(ThreadCorrelationId.class.getSimpleName(), threadCorrelationId);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
