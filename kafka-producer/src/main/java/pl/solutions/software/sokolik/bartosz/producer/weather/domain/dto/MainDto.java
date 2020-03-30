package pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainDto {

    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private float pressure;
    private float humidity;
}
