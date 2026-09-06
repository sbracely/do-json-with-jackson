package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonIdentityInfo;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonIdentityInfoTest {

    @Test
    void whenSerializingUsingJsonIdentityInfo_thenCorrect() {
        UserWithIdentity userWithIdentity = new UserWithIdentity();
        userWithIdentity.setId(1);
        userWithIdentity.name = "John Doe";
        ItemWithIdentity itemWithIdentity = new ItemWithIdentity();
        itemWithIdentity.setId(2);
        itemWithIdentity.itemName = "Item 1";
        itemWithIdentity.owner = userWithIdentity;
        userWithIdentity.userItems = List.of(itemWithIdentity);

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String userWithIdentityJson = jsonMapper.writeValueAsString(userWithIdentity);
        IO.println(userWithIdentityJson);
        assertThat(userWithIdentityJson)
                .contains("\"name\":\"John Doe\"")
                .contains("\"itemName\":\"Item 1\"")
                .contains("\"owner\":1");
        String itemWithIdentityJson = jsonMapper.writeValueAsString(itemWithIdentity);
        IO.println(itemWithIdentityJson);
        assertThat(itemWithIdentityJson)
                .contains("\"itemName\":\"Item 1\"")
                .contains("\"userItems\":[2]");

        UserWithIdentity deserializedUserWithIdentity = jsonMapper.readerFor(UserWithIdentity.class)
                .readValue(userWithIdentityJson);
        assertThat(deserializedUserWithIdentity.getId()).isEqualTo(1);
        assertThat(deserializedUserWithIdentity.name).isEqualTo("John Doe");
        assertThat(deserializedUserWithIdentity.userItems).hasSize(1);
        assertThat(deserializedUserWithIdentity.userItems.getFirst().getId()).isEqualTo(2);
        assertThat(deserializedUserWithIdentity.userItems.getFirst().itemName).isEqualTo("Item 1");
        assertThat(deserializedUserWithIdentity.userItems.getFirst().owner).isSameAs(deserializedUserWithIdentity);
        ItemWithIdentity deserializedItemWithIdentity = jsonMapper.readerFor(ItemWithIdentity.class)
                .readValue(itemWithIdentityJson);
        assertThat(deserializedItemWithIdentity.getId()).isEqualTo(2);
        assertThat(deserializedItemWithIdentity.itemName).isEqualTo("Item 1");
        assertThat(deserializedItemWithIdentity.owner).isNotNull();
        assertThat(deserializedItemWithIdentity.owner.getId()).isEqualTo(1);
        assertThat(deserializedItemWithIdentity.owner.name).isEqualTo("John Doe");
        assertThat(deserializedItemWithIdentity.owner.userItems).hasSize(1);
        assertThat(deserializedItemWithIdentity.owner.userItems.getFirst()).isSameAs(deserializedItemWithIdentity);

    }
}
