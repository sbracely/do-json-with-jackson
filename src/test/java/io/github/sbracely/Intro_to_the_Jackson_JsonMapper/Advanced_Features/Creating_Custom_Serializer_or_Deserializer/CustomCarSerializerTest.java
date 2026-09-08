package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Creating_Custom_Serializer_or_Deserializer;

import org.junit.jupiter.api.Test;
import tools.jackson.core.Version;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomCarSerializerTest {
    @Test
    void whenSerializingUsingCustomSerializer_thenCorrect() {
        SimpleModule customCarSerializer = new SimpleModule("CustomCarSerializer",
                new Version(1, 0, 0, null, null, null));
        customCarSerializer.addSerializer(Car.class, new CustomCarSerializer());
        JsonMapper jsonMapper = JsonMapper.builder()
                .addModule(customCarSerializer)
                .build();
        Car car = new Car();
        car.setColor("red");
        car.setType("renault");
        String json = jsonMapper.writeValueAsString(car);
        IO.println(json);
        assertThat(json).isEqualTo("""
                {"car_brand":"renault"}""");
        String jsonArray = jsonMapper.writeValueAsString(List.of(car));
        IO.println(jsonArray);
        assertThat(jsonArray).isEqualTo("""
                [{"car_brand":"renault"}]""");
    }

}
