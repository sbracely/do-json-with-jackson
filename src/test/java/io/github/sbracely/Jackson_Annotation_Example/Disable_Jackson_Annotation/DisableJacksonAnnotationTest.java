package io.github.sbracely.Jackson_Annotation_Example.Disable_Jackson_Annotation;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DisableJacksonAnnotationTest {
    @Test
    void whenDisablingAllAnnotations_thenAllDisabled() {
        MyBean myBean = new MyBean();
        myBean.id = 1;
        myBean.name = null;

        JsonMapper jsonMapper1 = JsonMapper.builder().build();
        String json1 = jsonMapper1.writeValueAsString(myBean);
        IO.println(json1);
        assertThat(json1).doesNotContain("name");

        JsonMapper jsonMapper2 = JsonMapper.builder().disable(MapperFeature.USE_ANNOTATIONS).build();
        String json2 = jsonMapper2.writeValueAsString(myBean);
        IO.println(json2);
        assertThat(json2).contains("name");
    }
}
