package pl.solutions.software.sokolik.bartosz.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendSmsRequest {

    @JsonProperty("body")
    private String body;

    @JsonProperty("phone")
    private String phone;

}
