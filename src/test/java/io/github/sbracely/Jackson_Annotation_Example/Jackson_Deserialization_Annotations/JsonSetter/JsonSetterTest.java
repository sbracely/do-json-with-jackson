package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonSetter;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThat(myBean).isNotNull();
        assertThat(myBean.id).isEqualTo(1);
        assertThat(myBean.getTheName()).isEqualTo("My Bean");
    }
}
