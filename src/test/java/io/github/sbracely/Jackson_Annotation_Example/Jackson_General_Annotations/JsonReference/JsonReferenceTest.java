package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonReference;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonReferenceTest {
    @Test
    void whenSerializingUsingJacksonReferenceAnnotation() {
        UserWithRef userWithRef = new UserWithRef();
        userWithRef.id = 1;
        userWithRef.name = "John Doe";
        ItemWithRef itemWithRef = new ItemWithRef();
        itemWithRef.id = 2;
        itemWithRef.itemName = "Item 1";
        itemWithRef.owner = userWithRef;
        userWithRef.userItems = List.of(itemWithRef);

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String userWithRefJson = jsonMapper.writeValueAsString(userWithRef);
        IO.println(userWithRefJson);
        assertThat(userWithRefJson)
                .contains("\"name\":\"John Doe\"")
                .contains("\"itemName\":\"Item 1\"")
                .doesNotContain("owner");

        String itemWithRefJson = jsonMapper.writeValueAsString(itemWithRef);
        IO.println(itemWithRefJson);
        assertThat(itemWithRefJson)
                .contains("\"itemName\":\"Item 1\"")
                .doesNotContain("owner");

        UserWithRef deserializedUserWithRef = jsonMapper.readerFor(UserWithRef.class).readValue(userWithRefJson);
        ItemWithRef deserializedItemWithRef = jsonMapper.readerFor(ItemWithRef.class).readValue(itemWithRefJson);

        assertThat(deserializedUserWithRef.id).isEqualTo(1);
        assertThat(deserializedUserWithRef.name).isEqualTo("John Doe");
        assertThat(deserializedUserWithRef.userItems).hasSize(1);
        assertThat(deserializedUserWithRef.userItems.getFirst().id).isEqualTo(2);
        assertThat(deserializedUserWithRef.userItems.getFirst().itemName).isEqualTo("Item 1");
        assertThat(deserializedUserWithRef.userItems.getFirst().owner) .isSameAs(deserializedUserWithRef);

        assertThat(deserializedItemWithRef.id).isEqualTo(2);
        assertThat(deserializedItemWithRef.itemName).isEqualTo("Item 1");
        assertThat(deserializedItemWithRef.owner).isNull();
    }
}
