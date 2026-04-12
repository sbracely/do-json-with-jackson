package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializerTest {
    @Test
    void whenSerializingUsingJsonSerialize_thenCorrect() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);

        String result = JsonMapper.builder().build().writeValueAsString(event);
        IO.println(result);

        Assertions.assertThat(result).contains(toParse);
    }
}
