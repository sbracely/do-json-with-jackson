package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAntySetter;

import io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAnySetter.ExtendableBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonAnySetterTest {
    @Test
    void whenDeserializingUsingJsonAnySetter_thenCorrect() {

        String json = """
                {
                    "name": "My bean",
                    "property1": "value1",
                    "property2": "value2"
                }
                """;
        ExtendableBean extendableBean = JsonMapper.builder().build()
                .readerFor(ExtendableBean.class)
                .readValue(json);
        Assertions.assertNotNull(extendableBean);
        Assertions.assertEquals("My bean", extendableBean.name);
        Assertions.assertEquals("value1", extendableBean.getProperties().get("property1"));
        Assertions.assertEquals("value2", extendableBean.getProperties().get("property2"));

    }
}
