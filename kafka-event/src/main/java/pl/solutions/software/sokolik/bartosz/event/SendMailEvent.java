package pl.solutions.software.sokolik.bartosz.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SendMailEvent extends Event {

    @JsonProperty("body")
    private String body;

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("subject")
    private String subject;

}
