package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonGetter;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonGetterTest {
    @Test
    public void whenSerializingUsingJsonGetter_thenCorrect() {
        MyBean bean = new MyBean(1, "My bean");

        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);

        assertThat(result)
                .contains("My bean", "1");
    }
}
