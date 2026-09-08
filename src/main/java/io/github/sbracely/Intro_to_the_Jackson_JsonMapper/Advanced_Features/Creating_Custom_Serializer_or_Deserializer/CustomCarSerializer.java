package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Creating_Custom_Serializer_or_Deserializer;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

public class CustomCarSerializer extends StdSerializer<Car> {

    public CustomCarSerializer() {
        super(Car.class);
    }

    @Override
    public void serialize(Car value, JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        gen.writeStartObject();
        gen.writeStringProperty("car_brand", value.getType());
        gen.writeEndObject();
    }
}
