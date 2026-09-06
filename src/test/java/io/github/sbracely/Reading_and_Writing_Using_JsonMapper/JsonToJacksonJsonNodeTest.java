package io.github.sbracely.Reading_and_Writing_Using_JsonMapper;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonToJacksonJsonNodeTest {
    @Test
    void readsJsonNodeFromJsonFile() throws URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("car.json")).toURI());
        JsonMapper jsonMapper = JsonMapper.builder().build();
        JsonNode jsonNode = jsonMapper.readTree(path);
        IO.println(jsonNode.toPrettyString());
        assertThat(jsonNode.get("color").asString()).isEqualTo("red");
        assertThat(jsonNode.get("type").asString()).isEqualTo("sedan");
    }
}
