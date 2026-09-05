package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonDeserialize;

import io.github.sbracely.Jackson_Annotation_Example.common.DateTimeUtil;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.deser.std.StdDeserializer;

import java.time.LocalDateTime;

public class CustomDateDeserializer extends StdDeserializer<LocalDateTime> {

    protected CustomDateDeserializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
        return LocalDateTime.parse(p.getValueAsString(), DateTimeUtil.FORMATTER);
    }
}
