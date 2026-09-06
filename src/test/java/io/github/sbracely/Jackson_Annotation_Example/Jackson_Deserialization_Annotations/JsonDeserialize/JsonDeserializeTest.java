package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonDeserialize;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.time.LocalDateTime;

public class JsonDeserializeTest {

    @Test
    void whenDeserializingUsingJsonDeserialize_thenCorrect() {
        String json = """
                {
                    "name": "My Event",
                    "eventDateTime": "20-12-2014 02:30:00"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        Event event = jsonMapper.readValue(json, Event.class);
        assertThat(event).isNotNull();
        assertThat(event.name).isEqualTo("My Event");
        LocalDateTime localDateTime = LocalDateTime.of(2014, 12, 20, 2, 30, 0);
        assertThat(event.eventDateTime).isEqualTo(localDateTime);
    }
}
