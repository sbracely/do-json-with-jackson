package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features;

import static org.junit.jupiter.api.Assertions.assertThrows;

import io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Car;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectReader;
import tools.jackson.databind.exc.UnrecognizedPropertyException;
import tools.jackson.databind.json.JsonMapper;

public class ConfiguringSerializationOrDeserializationFeatureTest {
    @Test
    void test() {
        String json = """
                {
                    "color" : "Black",
                    "type" : "Fiat",
                    "year" : "1970"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        boolean enabled = jsonMapper.deserializationConfig()
                .isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        IO.println("FAIL_ON_UNKNOWN_PROPERTIES is " + (enabled ? "enabled" : "disabled"));
        Car car = jsonMapper.readValue(json, Car.class);
        IO.println(car.getColor());
        IO.println(car.getType());

        // Now configure the ObjectReader to fail on unknown properties
        ObjectReader carReader = jsonMapper.readerFor(Car.class)
                .with(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        boolean enabled1 = carReader.isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        IO.println("FAIL_ON_UNKNOWN_PROPERTIES is " + (enabled1 ? "enabled" : "disabled"));

        assertThrows(UnrecognizedPropertyException.class, () -> carReader.readValue(json));

    }
}
