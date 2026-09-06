package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Reading_and_Writing_Using_JsonMapper;

import org.junit.jupiter.api.Test;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.type.CollectionType;
import tools.jackson.databind.type.MapType;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

    @Test
    void creatingAJavaListFromAJsonArrayString() {
        String jsonCarArray = """
                [
                  {
                    "color": "Black",
                    "type": "BMW"
                  },
                  {
                    "color": "Red",
                    "type": "FIAT"
                  }
                ]
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();

        // 1: Using readerForListOf
        List<Car> carList1 = jsonMapper.readerForListOf(Car.class).readValue(jsonCarArray);

        // 2: Using TypeReference
        TypeReference<List<Car>> typeReference = new TypeReference<>() {
        };
        List<Car> carList2 = jsonMapper.readValue(jsonCarArray, typeReference);

        // 3: Using CollectionType
        CollectionType collectionType = jsonMapper.getTypeFactory().constructCollectionType(List.class, Car.class);
        List<Car> carList3 = jsonMapper.readValue(jsonCarArray, collectionType);

        // 4: Using an array
        Car[] car = jsonMapper.readValue(jsonCarArray, Car[].class);
        List<Car> carList4 = Arrays.stream(car).toList();

        assertThat(carList1).hasSize(2);

        assertThat(carList1.get(0).getColor()).isEqualTo("Black");
        assertThat(carList1.get(0).getType()).isEqualTo("BMW");
        assertThat(carList1.get(1).getColor()).isEqualTo("Red");
        assertThat(carList1.get(1).getType()).isEqualTo("FIAT");

        assertThat(carList2).usingRecursiveComparison().isEqualTo(carList1);
        assertThat(carList3).usingRecursiveComparison().isEqualTo(carList1);
        assertThat(carList4).usingRecursiveComparison().isEqualTo(carList1);
    }

    @Test
    void creatingJavaMapFromJsonString() {
        String jsonCarMap = """
                {
                  "car1": {
                    "color": "Black",
                    "type": "BMW"
                  },
                  "car2": {
                    "color": "Red",
                    "type": "FIAT"
                  }
                }
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();

        // 1: Using  TypeReference
        TypeReference<Map<String, Car>> typeReference = new TypeReference<>() {
        };
        Map<String, Car> carMap1 = jsonMapper.readValue(jsonCarMap, typeReference);

        // 2: Using MapType
        MapType mapType = jsonMapper.getTypeFactory().constructMapType(Map.class, String.class, Car.class);
        Map<String, Car> carMap2 = jsonMapper.readValue(jsonCarMap, mapType);

        assertThat(carMap1).hasSize(2);
        assertThat(carMap1.get("car1").getColor()).isEqualTo("Black");
        assertThat(carMap1.get("car1").getType()).isEqualTo("BMW");
        assertThat(carMap1.get("car2").getColor()).isEqualTo("Red");
        assertThat(carMap1.get("car2").getType()).isEqualTo("FIAT");

        assertThat(carMap2).usingRecursiveComparison().isEqualTo(carMap1);
    }
}
