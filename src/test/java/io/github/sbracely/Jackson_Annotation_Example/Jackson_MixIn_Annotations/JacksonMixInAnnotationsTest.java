package io.github.sbracely.Jackson_Annotation_Example.Jackson_MixIn_Annotations;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JacksonMixInAnnotationsTest {
    @Test
    void whenSerializingUsingMixInAnnotation_thenCorrect() {
        Item item = new Item();
        item.id = 1;
        item.itemName = "item name";

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String itemJson = jsonMapper.writeValueAsString(item);
        IO.println(itemJson);
        jsonMapper = JsonMapper.builder().addMixIn(User.class, MyMixInForIgnoreType.class)
                .build();
        String itemJsonWithMixIn = jsonMapper.writeValueAsString(item);
        IO.println(itemJsonWithMixIn);

    }
}
