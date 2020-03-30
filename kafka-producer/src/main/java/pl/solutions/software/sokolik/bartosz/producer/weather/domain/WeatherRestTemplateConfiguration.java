package pl.solutions.software.sokolik.bartosz.producer.weather.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.solutions.software.sokolik.bartosz.event.correlation.web.CorrelationIdInterceptor;

@Configuration
public class WeatherRestTemplateConfiguration {

    private static final String API_KEY_HEADER_NAME = "x-rapidapi-key";

    private final String weatherUrl;
    private final String apiWeatherKey;

    public WeatherRestTemplateConfiguration(@Value("${external.weather.api.url}") String weatherUrl,
                                            @Value("${external.weather.api.key}") String apiWeatherKey) {
        this.weatherUrl = weatherUrl;
        this.apiWeatherKey = apiWeatherKey;
    }

    @Bean
    public RestTemplate weatherRestTemplate(RestTemplateBuilder builder, CorrelationIdInterceptor correlationIdInterceptor) {
        return builder.interceptors(correlationIdInterceptor)
                .rootUri(weatherUrl)
                .defaultHeader(API_KEY_HEADER_NAME, apiWeatherKey)
                .build();
    }
}
