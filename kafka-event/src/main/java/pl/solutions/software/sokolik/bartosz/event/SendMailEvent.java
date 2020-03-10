package pl.solutions.software.sokolik.bartosz.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SendMailEvent extends Event {

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("subject")
    private String subject;

}
