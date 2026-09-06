package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonFormat;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.time.LocalDateTime;

public class JsonFormatTest {
    @Test
    void whenSerializingUsingJsonFormat_thenCorrect() {
        Event event = new Event();
        event.name = "name";
        event.eventDateTime = LocalDateTime.now();
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(event);
        IO.println(json);
        assertThat(json).containsPattern("\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}");
    }
}
