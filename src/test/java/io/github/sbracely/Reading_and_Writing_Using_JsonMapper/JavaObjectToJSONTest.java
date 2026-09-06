package io.github.sbracely.Reading_and_Writing_Using_JsonMapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class JavaObjectToJSONTest {

    private static final Path OUTPUT_PATH = Path.of("target", "car.json");

    @AfterEach
    void removeGeneratedFile() throws IOException {
        Files.deleteIfExists(OUTPUT_PATH);
    }

    @Test
    void writesCarAsJsonFile() throws IOException {
        Car car = new Car();
        car.setColor("red");
        car.setType("sedan");
        JsonMapper.builder().build().writeValue(OUTPUT_PATH, car);

        assertThat(Files.exists(OUTPUT_PATH)).isTrue();
        assertThat(Files.readString(OUTPUT_PATH))
                .isEqualTo("{\"color\":\"red\",\"type\":\"sedan\"}");
    }
}
