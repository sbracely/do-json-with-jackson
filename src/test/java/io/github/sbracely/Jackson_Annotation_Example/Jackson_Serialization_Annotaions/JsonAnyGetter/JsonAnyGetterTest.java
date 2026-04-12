package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonAnyGetter;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonAnyGetterTest {

    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect() {
        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);

        assertThat(result)
                .contains("attr1", "val1");
    }
}
