package pl.solutions.software.sokolik.bartosz.producer.weather.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto.WeatherServiceResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final String WEATHER_URL = "/weather?q={city}";

    private final RestTemplate restTemplate;

    public WeatherServiceResponse getWeatherForCity(String city) {
        log.info("Getting weather for city: {}", city);
        ResponseEntity<WeatherServiceResponse> response = restTemplate.exchange(WEATHER_URL, HttpMethod.GET, HttpEntity.EMPTY, WeatherServiceResponse.class, city);
        return response.getBody();
    }
}
