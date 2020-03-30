package pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordDto {

    private float lon;
    private float lat;
}
