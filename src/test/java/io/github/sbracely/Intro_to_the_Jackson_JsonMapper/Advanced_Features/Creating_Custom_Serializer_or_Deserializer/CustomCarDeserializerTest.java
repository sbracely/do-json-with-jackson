package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Creating_Custom_Serializer_or_Deserializer;

import org.junit.jupiter.api.Test;
import tools.jackson.core.Version;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomCarDeserializerTest {
    @Test
    void deserializesCarWithCustomDeserializer() {
        String json = """
                {
                    "color": "red",
                    "type": "BMW"
                }
                """;
        SimpleModule customCarDeserializer = new SimpleModule("CustomCarDeserializer",
                new Version(1, 0, 0, null, null, null));
        customCarDeserializer.addDeserializer(Car.class, new CustomCarDeserializer());
        JsonMapper jsonMapper = JsonMapper.builder()
                .addModule(customCarDeserializer)
                .build();
        Car car = jsonMapper.readValue(json, Car.class);
        assertThat(car.getColor()).isEqualTo("red");
        assertThat(car.getType()).isNull();
    }
}
