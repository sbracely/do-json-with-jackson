package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAlias;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals("John", jsonAlias1.getFirstName());
        Assertions.assertEquals("John", jsonAlias1.getFirstName());
        Assertions.assertEquals("Doe", jsonAlias2.getLastName());
        Assertions.assertEquals("Doe", jsonAlias2.getLastName());
    }
}
