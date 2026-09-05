package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializerTest {
    @Test
    void whenSerializingUsingJsonSerialize_thenCorrect() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        LocalDateTime eventDateTime = LocalDateTime.parse(toParse, dateTimeFormatter);
        Event event = new Event("party", eventDateTime);

        String result = JsonMapper.builder().build().writeValueAsString(event);
        IO.println(result);

        Assertions.assertThat(result).contains(toParse);
    }
}
