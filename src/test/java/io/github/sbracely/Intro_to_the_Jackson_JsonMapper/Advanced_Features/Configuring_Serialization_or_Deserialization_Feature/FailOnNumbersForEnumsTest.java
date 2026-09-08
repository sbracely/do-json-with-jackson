package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Configuring_Serialization_or_Deserialization_Feature;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.cfg.EnumFeature;
import tools.jackson.databind.exc.InvalidFormatException;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.*;

public class FailOnNumbersForEnumsTest {

    @Test
    void defaultMapperAllowsNumericEnumValues() {
        String json = """
                {
                    "color" : 1,
                    "type" : "Fiat"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        boolean enabled = jsonMapper.isEnabled(EnumFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        IO.println("FAIL_ON_NUMBERS_FOR_ENUMS enabled: " + enabled);
        assertThat(enabled).isFalse();
        assertThatNoException().isThrownBy(() -> jsonMapper.readValue(json, CarWithEnum.class));
        CarWithEnum carWithEnum = jsonMapper.readValue(json, CarWithEnum.class);
        IO.println("color: " + carWithEnum.getColor());
        assertThat(carWithEnum.getColor()).isEqualTo(CarWithEnum.Color.GREEN);
    }

    @Test
    void configuredMapperFailsOnNumericEnumValues() {
        String json = """
                {
                    "color" : 1,
                    "type" : "Fiat"
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder()
                .enable(EnumFeature.FAIL_ON_NUMBERS_FOR_ENUMS)
                .build();
        boolean enabled = jsonMapper.isEnabled(EnumFeature.FAIL_ON_NUMBERS_FOR_ENUMS);
        IO.println("FAIL_ON_NUMBERS_FOR_ENUMS enabled: " + enabled);
        assertThat(enabled).isTrue();
        assertThatThrownBy(() -> jsonMapper.readValue(json, CarWithEnum.class))
                .isExactlyInstanceOf(InvalidFormatException.class)
                .hasMessageContaining("not allowed to deserialize Enum value out of number");
    }
}
