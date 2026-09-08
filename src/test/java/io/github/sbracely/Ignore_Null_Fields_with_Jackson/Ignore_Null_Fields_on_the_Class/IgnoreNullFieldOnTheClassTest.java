package io.github.sbracely.Ignore_Null_Fields_with_Jackson.Ignore_Null_Fields_on_the_Class;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class IgnoreNullFieldOnTheClassTest {
    @Test
    void ignoresNullFieldsAnnotatedOnTheClass() {
        MyDto myDto = new MyDto();
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("stringValue", "null");
    }

    @Test
    void ignoresNullFieldsAnnotatedOnTheField() {
        MyDtoWithNullField myDto = new MyDtoWithNullField();
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("stringValue", "null");
    }
}
