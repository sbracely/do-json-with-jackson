package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonValue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class TypeEnumWithValueTest {

    @Test
    void whenSerializingUsingJsonValue_thenCorrect() {
        String enumAsString = JsonMapper.builder().build().writeValueAsString(TypeEnumWithValue.TYPE1);
        IO.println(enumAsString);
        Assertions.assertThat(enumAsString).isEqualTo("\"Type A\"");
    }
}
