package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonRootName;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.dataformat.xml.XmlMapper;

public class UserWithRootTest {
    @Test
    void whenSerializingUsingJsonRootName_thenCorrect() {
        UserWithRoot user = new UserWithRoot(1, "John");
        String result = JsonMapper.builder()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .build()
                .writeValueAsString(user);
        IO.println(result);

        assertThat(result)
                .containsSubsequence("user", "John");
    }

    @Test
    void whenSerializingUsingJsonRootName_namespace_thenCorrect() {
        UserWithRoot user = new UserWithRoot(1, "John");
        String result = XmlMapper.builder()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .build()
                .writeValueAsString(user);
        IO.println(result);

        assertThat(result)
                .containsSubsequence("user xmlns=\"users\"", "John");
    }
}
