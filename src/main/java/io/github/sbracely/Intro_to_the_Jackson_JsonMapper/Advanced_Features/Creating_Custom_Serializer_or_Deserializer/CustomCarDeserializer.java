package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Creating_Custom_Serializer_or_Deserializer;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.deser.std.StdDeserializer;

public class CustomCarDeserializer extends StdDeserializer<Car> {

    public CustomCarDeserializer() {
        super(Car.class);
    }

    @Override
    public Car deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        JsonNode jsonNode = ctxt.readTree(p);
        JsonNode jsonNodeColor = jsonNode.get("color");
        String color = jsonNodeColor.asString();

        Car car = new Car();
        car.setColor(color);
        return car;
    }
}
