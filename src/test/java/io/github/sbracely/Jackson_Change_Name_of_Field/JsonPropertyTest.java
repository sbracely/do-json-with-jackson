package io.github.sbracely.Jackson_Change_Name_of_Field;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPropertyTest {
    @Test
    void test() {
        MyDto myDto = new MyDto();
        myDto.setStringValue("test");
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).contains("strVal", "test")
                .doesNotContain("stringValue");
    }
}
