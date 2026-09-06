package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAlias;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonAliasTest {
    @Test
    void whenDeserializingUsingJsonAlias_thenCorrect() {
        String json1 = """
                {
                    "f_name":"John",
                    "lastName":"Doe"
                }
                """;
        String json2 = """
                {
                    "fName":"John",
                    "lastName":"Doe"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        AliasBean jsonAlias1 = jsonMapper.readValue(json1, AliasBean.class);
        AliasBean jsonAlias2 = jsonMapper.readValue(json2, AliasBean.class);
        Assertions.assertThat(jsonAlias1.getFirstName()).isEqualTo("John");
        Assertions.assertThat(jsonAlias1.getFirstName()).isEqualTo("John");
        Assertions.assertThat(jsonAlias2.getLastName()).isEqualTo("Doe");
        Assertions.assertThat(jsonAlias2.getLastName()).isEqualTo("Doe");
    }
}
