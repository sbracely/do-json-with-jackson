package io.github.sbracely.JacksonIgnorePropertiesOnMarshalling.IgnoreFieldAtTheFieldLevel;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class IgnoreFieldAtTheFieldLevelTest {
    @Test
    void ignoresFieldAtTheFieldLevel() {
        MyDto myDto = new MyDto();
        myDto.setIntValue(1);
        myDto.setStringValue("string");
        myDto.setBoolValue(true);
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("intValue","1");
    }
}
