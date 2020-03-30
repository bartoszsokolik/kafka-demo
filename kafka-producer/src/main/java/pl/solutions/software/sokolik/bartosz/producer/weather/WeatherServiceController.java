package pl.solutions.software.sokolik.bartosz.producer.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.solutions.software.sokolik.bartosz.producer.weather.domain.WeatherService;
import pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto.WeatherServiceResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/weather")
public class WeatherServiceController {

    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherServiceResponse> getWeatherForCity(@RequestParam(defaultValue = "Warsaw") String city) {
        return ResponseEntity.ok(weatherService.getWeatherForCity(city));
    }
}
