package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonRawValue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class RawBeanTest {
    @Test
    void whenSerializingUsingJsonRawValue_thenCorrect() {
        RawBean bean = new RawBean("My bean", """
                {
                    "attr":false
                }
                """);
        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);
        Assertions.assertThat(result)
                .contains("My bean", """
                        {
                            "attr":false
                        }
                        """);
    }

    @Test
    void whenSerializingUsingJsonRawValue_valueFalse_thenCorrect() {
        RawBeanValueFalse bean = new RawBeanValueFalse("My bean", """
                {
                    "attr":false
                }
                """);
        String result = JsonMapper.builder().build().writeValueAsString(bean);
        IO.println(result);
        Assertions.assertThat(result)
                .contains("My bean", """
                        {\\n    \\"attr\\":false\\n}\\n""");
    }
}
