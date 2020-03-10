package pl.solutions.software.sokolik.bartosz.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SendMailEvent.class, name = "SendMailEvent"),
        @JsonSubTypes.Type(value = SendSmsEvent.class, name = "SendSmsEvent")
})
@EqualsAndHashCode
public class Event {

}
