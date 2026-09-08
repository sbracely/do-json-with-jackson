package io.github.sbracely.Jackson_Ignore_Properties_on_Marshalling.Ignore_All_Fields_by_Type;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonIgnoreTypeTest {
    @Test
    void shouldNotSerializeIgnoredTypeFieldsByDefault() {
        SomeType someType = new SomeType();
        someType.setString("string");
        MyDto myDto = new MyDto();
        myDto.setSomeType(someType);
        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("someType", "string");
    }

    @Test
    void shouldIgnoreConfiguredTypeAndKeepAllowedField() {
        UncontrolledType uncontrolledType = new UncontrolledType();
        uncontrolledType.setString("string");
        MyDto myDto = new MyDto();
        myDto.setUncontrolledType(uncontrolledType);
        myDto.setIntValue(123);
        JsonMapper jsonMapper = JsonMapper.builder()
                .addMixIn(UncontrolledType.class, MyMixInForIgnoreType.class)
                .addMixIn(int.class, MyMixInForIgnoreType.class)
                .build();
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("uncontrolled", "string")
                .contains("int", "123");
    }
}
