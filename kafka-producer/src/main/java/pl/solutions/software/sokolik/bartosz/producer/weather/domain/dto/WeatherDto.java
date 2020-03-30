package pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private float id;
    private String main;
    private String description;
    private String icon;
}