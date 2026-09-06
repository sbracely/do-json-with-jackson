package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JsonViewTest {

    @Test
    void whenSerializingUsingJsonView_thenCorrect() {
        Item item = new Item();
        item.id = 2;
        item.itemName = "itemName";
        item.ownerName = "ownerName";

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String publicJson = jsonMapper.writerWithView(Views.Public.class)
                .writeValueAsString(item);
        IO.println(publicJson);
        Assertions.assertThat(publicJson).contains("\"id\":2");
        Assertions.assertThat(publicJson).contains("\"itemName\":\"itemName\"");
        Assertions.assertThat(publicJson).doesNotContain("ownerName");
        String internalJson = jsonMapper.writerWithView(Views.Internal.class)
                .writeValueAsString(item);
        IO.println(internalJson);
        Assertions.assertThat(internalJson).contains("\"id\":2");
        Assertions.assertThat(internalJson).contains("\"itemName\":\"itemName\"");
        Assertions.assertThat(internalJson).contains("\"ownerName\":\"ownerName\"");
    }
}
