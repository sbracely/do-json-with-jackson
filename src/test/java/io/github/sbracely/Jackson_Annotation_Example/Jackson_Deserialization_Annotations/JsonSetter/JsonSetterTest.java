package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonSetter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonSetterTest {
    @Test
    void whenDeserializingUsingJsonSetter_thenCorrect() {
        String json = """
                {
                    "id": 1,
                    "name": "My Bean"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        MyBean myBean = jsonMapper.readValue(json, MyBean.class);
        Assertions.assertThat(myBean).isNotNull();
        Assertions.assertThat(myBean.id).isEqualTo(1);
        Assertions.assertThat(myBean.getTheName()).isEqualTo("My Bean");
    }
}
