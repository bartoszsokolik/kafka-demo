package pl.solutions.software.sokolik.bartosz.producer.weather.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherServiceResponse {

    @JsonProperty("coord")
    private CoordDto coord;

    @JsonProperty("main")
    private MainDto main;

    @JsonProperty("wind")
    private WindDto wind;

    @JsonProperty("clouds")
    private CloudsDto clouds;

    @JsonProperty("sys")
    private SysDto sys;

    private String base;

    private float visibility;

    private float dt;

    private float timezone;

    private float id;

    private String name;

    private float cod;

    @JsonProperty("weather")
    private List<WeatherDto> weather;
}
