package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Configuring_Serialization_or_Deserialization_Feature;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectReader;
import tools.jackson.databind.exc.MismatchedInputException;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.*;

public class FailOnNullForPrimitivesTest {
    @Test
    void missingPrimitiveValueDoesNotFailDeserialization() {
        String json = """
                {
                    "color" : "Black",
                    "type" : "Fiat"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        boolean enabled = jsonMapper.deserializationConfig()
                .isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        IO.println("FAIL_ON_NULL_FOR_PRIMITIVES enabled: " + enabled);
        assertThat(enabled).isTrue();
        assertThatNoException().isThrownBy(() -> jsonMapper.readValue(json, CarWithYear.class));

        ObjectReader objectReader = jsonMapper.readerFor(CarWithYear.class)
                .without(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        boolean readerEnabled = objectReader.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        IO.println("FAIL_ON_NULL_FOR_PRIMITIVES enabled: " + readerEnabled);
        assertThat(readerEnabled).isFalse();
        assertThatNoException().isThrownBy(() -> objectReader.readValue(json));
    }

    @Test
    void nullPrimitiveValueFailsDeserializationByDefault() {
        String json = """
                {
                    "color" : "Black",
                    "type" : "Fiat",
                    "year" : null
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        boolean enabled = jsonMapper.deserializationConfig()
                .isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        IO.println("FAIL_ON_NULL_FOR_PRIMITIVES enabled: " + enabled);
        assertThat(enabled).isTrue();
        assertThatThrownBy(() -> jsonMapper.readValue(json, CarWithYear.class))
                .isExactlyInstanceOf(MismatchedInputException.class)
                .hasMessageContaining("Cannot map `null` into type `int`");

        ObjectReader objectReader = jsonMapper.readerFor(CarWithYear.class)
                .without(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        boolean readerEnabled = objectReader.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);
        IO.println("FAIL_ON_NULL_FOR_PRIMITIVES enabled: " + readerEnabled);
        assertThat(readerEnabled).isFalse();
        assertThatNoException().isThrownBy(() -> objectReader.readValue(json));
    }
}
