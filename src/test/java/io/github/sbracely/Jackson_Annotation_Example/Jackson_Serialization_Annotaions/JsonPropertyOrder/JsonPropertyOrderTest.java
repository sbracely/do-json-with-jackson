package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonPropertyOrder;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonPropertyOrderTest {

    @Test
    void whenSerializingUsingJsonPropertyOrder_thenCorrect() {
        MyBean bean = new MyBean(1, "My bean");

        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);

        assertThat(result)
                .containsSubsequence("My bean", "1");
    }

    @Test
    void whenSerializingUsingJsonPropertyOrder_alphabeticTrue_thenCorrect() {
        MyBeanAlphabetic bean = new MyBeanAlphabetic(1, "My bean");
        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);
        assertThat(result)
                .containsSubsequence("1", "My bean");
    }
}
