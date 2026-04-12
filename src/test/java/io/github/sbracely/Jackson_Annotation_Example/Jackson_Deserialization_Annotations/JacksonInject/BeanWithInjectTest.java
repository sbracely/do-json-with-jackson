package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JacksonInject;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.InjectableValues;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanWithInjectTest {
    @Test
    public void whenDeserializingUsingJsonInject_thenCorrect() {
        String json = """
                {
                    "name": "My bean"
                }
                """;
        InjectableValues.Std inject = new InjectableValues.Std()
                .addValue(int.class, 1);
        BeanWithInject bean = JsonMapper.builder().build()
                .reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
        assertThat(bean.name).isEqualTo("My bean");
        assertThat(bean.id).isEqualTo(1);
    }

}
