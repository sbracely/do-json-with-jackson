package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonValue;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class TypeEnumWithValueTest {

    @Test
    void whenSerializingUsingJsonValue_thenCorrect() {
        String enumAsString = JsonMapper.builder().build().writeValueAsString(TypeEnumWithValue.TYPE1);
        IO.println(enumAsString);
        assertThat(enumAsString).isEqualTo("\"Type A\"");
    }

    @Test
    void whenSerializingUsingJsonValue_thenCorrect2() {
        JsonMapper jsonMapper = JsonMapper.builder().build();
        BeanWithEnum beanWithEnum = new BeanWithEnum("name", TypeEnumWithValue.TYPE1);
        String jsonString = jsonMapper.writeValueAsString(beanWithEnum);
        IO.println(jsonString);
        assertThat(jsonString).contains("\"Type A\"");
    }
}
