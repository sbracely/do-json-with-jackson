package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features;

import io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Car;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectReader;
import tools.jackson.databind.exc.UnrecognizedPropertyException;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConfiguringSerializationOrDeserializationFeatureTest {
    private static final String JSON = """
            {
                "color" : "Black",
                "type" : "Fiat",
                "year" : "1970"
            }
            """;

    @Test
    void defaultMapperIgnoresUnknownProperties() {
        JsonMapper jsonMapper = JsonMapper.builder().build();

        boolean enabled = jsonMapper.deserializationConfig()
                .isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        assertThat(enabled).isFalse();

        Car car = jsonMapper.readValue(JSON, Car.class);
        assertThat(car.getColor()).isEqualTo("Black");
        assertThat(car.getType()).isEqualTo("Fiat");

        JsonNode jsonNode = jsonMapper.readTree(JSON);
        assertThat(jsonNode.get("year").asString()).isEqualTo("1970");
    }

    @Test
    void configuredReaderFailsOnUnknownProperties() {
        JsonMapper jsonMapper = JsonMapper.builder().build();
        ObjectReader carReader = jsonMapper.readerFor(Car.class)
                .with(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        boolean enabled = carReader.isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        assertThat(enabled).isTrue();

        assertThrows(UnrecognizedPropertyException.class, () -> carReader.readValue(JSON));
    }
}
