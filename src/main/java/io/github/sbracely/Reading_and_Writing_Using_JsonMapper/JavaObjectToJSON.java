package io.github.sbracely.Reading_and_Writing_Using_JsonMapper;

import tools.jackson.databind.json.JsonMapper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaObjectToJSON {
    static void main() {
        Car car = new Car();
        car.setColor("red");
        car.setType("sedan");
        JsonMapper jsonMapper = JsonMapper.builder().build();
        Path path = Paths.get("target/car.json");
        jsonMapper.writeValue(path, car);
    }
}
