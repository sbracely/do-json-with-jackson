package io.github.sbracely.JacksonIgnorePropertiesOnMarshalling.IgnoreFieldsAtTheClassLevel;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.exc.UnrecognizedPropertyException;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.*;

public class JsonIgnorePropertiesTest {
    @Test
    void shouldIgnoreAnnotatedFieldsWhenWritingJson() {
        MyDto myDto = new MyDto();
        myDto.setBoolValue(true);
        myDto.setIntValue(123);
        myDto.setStringValue("test");
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("intValue", "123");
    }

    @Test
    void shouldRejectUnknownPropertiesWhenReadingJson() {
        String json = """
                {
                    "booleanValue": true,
                    "intValue": 123,
                    "stringValue": "string",
                    "test": "test"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder()
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
        assertThatThrownBy(() -> jsonMapper.readValue(json, MyDto.class))
                .isExactlyInstanceOf(UnrecognizedPropertyException.class);
        assertThatNoException()
                .isThrownBy(() -> jsonMapper.readValue(json, MyDtoUnknowProperties.class));
    }
}
