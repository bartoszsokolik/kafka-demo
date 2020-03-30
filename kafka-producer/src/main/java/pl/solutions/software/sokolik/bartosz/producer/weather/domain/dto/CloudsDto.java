package pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CloudsDto {

    @JsonProperty("all")
    private float all;
}
