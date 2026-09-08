package io.github.sbracely.JacksonIgnorePropertiesOnMarshalling.IgnoreFieldsAtTheClassLevel;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonIgnorePropertiesTest {
    @Test
    void test() {
        MyDto myDto = new MyDto();
        myDto.setBoolValue(true);
        myDto.setIntValue(123);
        myDto.setStringValue("test");
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("intValue","123");
    }
}
