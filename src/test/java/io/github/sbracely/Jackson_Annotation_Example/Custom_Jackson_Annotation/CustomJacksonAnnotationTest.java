package io.github.sbracely.Jackson_Annotation_Example.Custom_Jackson_Annotation;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomJacksonAnnotationTest {
    @Test
    void whenSerializingUsingCustomAnnotation_thenCorrect() {
        BeanWithCustomAnnotation bean = new BeanWithCustomAnnotation();
        bean.id = 1;
        bean.name = "Test Name";
        bean.dateCreated = null;

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(bean);
        IO.println(json);

        assertThat(json).contains("\"name\":\"Test Name\"")
                .doesNotContain("dateCreated");
    }
}
