package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonUnwrapped;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonUnwrappedTest {

    @Test
    void whenSerializingUsingJsonUnwrapped_thenCorrect() {
        UnwrappedUser.Name name = new UnwrappedUser.Name();
        name.firstName = "John";
        name.lastName = "Doe";

        UnwrappedUser unwrappedUser = new UnwrappedUser();
        unwrappedUser.id = 1;
        unwrappedUser.name = name;

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writeValueAsString(unwrappedUser);
        IO.println(json);

        Assertions.assertThat(json).contains("\"id\":1");
        Assertions.assertThat(json).contains("\"firstName\":\"John\"");
        Assertions.assertThat(json).contains("\"lastName\":\"Doe\"");

        UnwrappedUser unwrappedUser2 = jsonMapper.readValue(json, UnwrappedUser.class);
        Assertions.assertThat(unwrappedUser2.id).isEqualTo(1);
        Assertions.assertThat(unwrappedUser2.name.firstName).isEqualTo("John");
        Assertions.assertThat(unwrappedUser2.name.lastName).isEqualTo("Doe");
    }
}
