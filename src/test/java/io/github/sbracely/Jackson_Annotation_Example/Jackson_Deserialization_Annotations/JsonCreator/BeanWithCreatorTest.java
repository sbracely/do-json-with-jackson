package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonCreator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class BeanWithCreatorTest {
    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() {
        String json = """
                    {
                        "id":1,
                        "theName":"My bean"
                    }
                """;
        BeanWithCreator bean = JsonMapper.builder().build()
                .readerFor(BeanWithCreator.class)
                .readValue(json);
        assertThat(bean.name).isEqualTo("My bean");
    }
}
