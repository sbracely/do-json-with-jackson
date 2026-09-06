package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonProperty;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonPropertyTest {
    @Test
    void whenUsingJsonProperty_thenCorrect() {
        MyBean myBean = new MyBean();
        myBean.id = 1;
        myBean.setTheName("Test Name");

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(myBean);
        IO.println(json);
        Assertions.assertThat(json).contains("\"name\":\"Test Name\"");

        MyBean myBean2 = jsonMapper.readValue(json, MyBean.class);
        Assertions.assertThat(myBean2.getTheName()).isEqualTo("Test Name");
    }
}
