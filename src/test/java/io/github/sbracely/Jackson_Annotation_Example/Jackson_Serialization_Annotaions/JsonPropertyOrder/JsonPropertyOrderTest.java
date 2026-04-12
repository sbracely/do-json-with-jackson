package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonPropertyOrder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonPropertyOrderTest {

    @Test
    void whenSerializingUsingJsonPropertyOrder_thenCorrect() {
        MyBean bean = new MyBean(1, "My bean");
        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);
        Assertions.assertThat(result)
                .containsSubsequence("My bean", "1");
    }
}
