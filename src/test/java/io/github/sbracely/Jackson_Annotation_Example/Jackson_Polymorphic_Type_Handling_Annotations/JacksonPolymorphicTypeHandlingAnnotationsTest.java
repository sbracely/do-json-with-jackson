package io.github.sbracely.Jackson_Annotation_Example.Jackson_Polymorphic_Type_Handling_Annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

public class JacksonPolymorphicTypeHandlingAnnotationsTest {

    @Test
    void whenSerializingPolymorphic_thenCorrect() {
        Dog dog = new Dog("lazy");
        Zoo zoo = new Zoo(dog);

        JsonMapper jsonMapper = JsonMapper.builder().build();

        String json = jsonMapper.writeValueAsString(zoo);
        IO.println(json);
        Assertions.assertTrue(json.contains("\"type\":\"dog\""));
    }

    @Test
    void whenDeserializingPolymorphic_thenCorrect() {
        String catJson = """
                {
                    "animal": {
                        "type": "cat",
                        "name": "lacy"
                    }
                }
                """;

        JsonMapper jsonMapper = JsonMapper.builder().build();
        Zoo zoo = jsonMapper.readerFor(Zoo.class).readValue(catJson);
        Assertions.assertInstanceOf(Cat.class, zoo.animal);
        Assertions.assertEquals("lacy", zoo.animal.name);
    }
}
