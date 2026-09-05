package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonSetter;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertNotNull(myBean);
        Assertions.assertEquals(1, myBean.id);
        Assertions.assertEquals("My Bean", myBean.getTheName());
    }
}
