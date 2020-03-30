package pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDto {

    private float type;
    private float id;
    private String country;
    private float sunrise;
    private float sunset;

}
