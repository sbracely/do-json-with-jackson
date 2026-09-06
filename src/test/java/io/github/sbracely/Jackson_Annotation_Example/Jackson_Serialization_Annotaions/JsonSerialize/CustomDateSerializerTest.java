package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.time.LocalDateTime;

public class CustomDateSerializerTest {
    @Test
    void whenSerializingUsingJsonSerialize_thenCorrect() {
        LocalDateTime eventDateTime = LocalDateTime.of(2014, 12, 20, 2, 30, 0);
        Event event = new Event("name", eventDateTime);

        String result = JsonMapper.builder().build().writeValueAsString(event);
        IO.println(result);

        String toParse = "20-12-2014 02:30:00";
        assertThat(result).contains(toParse);
    }
}
