package io.github.sbracely.Reading_and_Writing_Using_JsonMapper;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonToJavaObjectTest {

    @Test
    void readsCarFromJsonFile() throws URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("car.json")).toURI());
        JsonMapper jsonMapper = JsonMapper.builder().build();
        Car car = jsonMapper.readValue(path, Car.class);
        assertThat(car.getColor()).isEqualTo("red");
        assertThat(car.getType()).isEqualTo("sedan");
    }
}
