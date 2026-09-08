package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.HandlingCollections;

import org.junit.jupiter.api.Test;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HandlingCollectionsTest {
    @Test
    void readsCarArrayAndListFromJsonArrayString() {
        String json = """
                [
                     {
                         "color": "black",
                         "type": "BMW"
                     },
                     {
                         "color": "red",
                         "type": "FIAT"
                     }
                ]
                """;
        JsonMapper jsonMapper = JsonMapper.builder().build();
        Car[] cars = jsonMapper.readValue(json, Car[].class);
        IO.println(Arrays.toString(cars));
        assertThat(cars).hasSize(2);
        assertThat(cars[0].getColor()).isEqualTo("black");
        assertThat(cars[0].getType()).isEqualTo("BMW");
        assertThat(cars[1].getColor()).isEqualTo("red");
        assertThat(cars[1].getType()).isEqualTo("FIAT");

        List<Car> carsList = jsonMapper.readValue(json, new TypeReference<>() {
        });
        IO.println(carsList);
        assertThat(carsList).hasSize(2);
        assertThat(carsList).extracting(Car::getColor).containsExactly("black", "red");
        assertThat(carsList).extracting(Car::getType).containsExactly("BMW", "FIAT");
    }
}
