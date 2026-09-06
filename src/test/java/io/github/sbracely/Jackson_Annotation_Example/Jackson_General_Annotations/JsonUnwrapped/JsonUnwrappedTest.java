package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonUnwrapped;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(json).contains("\"id\":1")
                .contains("\"firstName\":\"John\"")
                .contains("\"lastName\":\"Doe\"");

        UnwrappedUser unwrappedUser2 = jsonMapper.readValue(json, UnwrappedUser.class);
        assertThat(unwrappedUser2)
                .extracting(user -> user.id, user -> user.name.firstName, user -> user.name.lastName)
                .containsExactly(1, "John", "Doe");
    }
}
