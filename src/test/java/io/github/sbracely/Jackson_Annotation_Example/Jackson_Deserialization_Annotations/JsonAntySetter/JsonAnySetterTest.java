package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAntySetter;

import io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAnySetter.ExtendableBean;
import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(extendableBean).isNotNull();
        Assertions.assertThat(extendableBean.name).isEqualTo("My bean");
        Assertions.assertThat(extendableBean.getProperties().get("property1")).isEqualTo("value1");
        Assertions.assertThat(extendableBean.getProperties().get("property2")).isEqualTo("value2");

    }
}
