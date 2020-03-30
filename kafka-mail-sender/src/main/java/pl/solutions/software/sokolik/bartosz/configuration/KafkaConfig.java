package pl.solutions.software.sokolik.bartosz.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import pl.solutions.software.sokolik.bartosz.event.Event;
import pl.solutions.software.sokolik.bartosz.event.SendMailEvent;
import pl.solutions.software.sokolik.bartosz.event.correlation.kafka.SendMailEventRecordInterceptor;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    private final String bootstrapServer;

    public KafkaConfig(@Value("${kafka.bootstrap-servers}") String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    @Bean
    public ConsumerFactory<String, SendMailEvent> consumerFactory() {
        Map<String, Object> consumerConfig = new HashMap<>();

        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), new JsonDeserializer<>(Event.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SendMailEvent> kafkaListenerContainerFactory(SendMailEventRecordInterceptor sendMailEventRecordInterceptor) {
        ConcurrentKafkaListenerContainerFactory<String, SendMailEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setRecordInterceptor(sendMailEventRecordInterceptor);
        return factory;
    }
}
