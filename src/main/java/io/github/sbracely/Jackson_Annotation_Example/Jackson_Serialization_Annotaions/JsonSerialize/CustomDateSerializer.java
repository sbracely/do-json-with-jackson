package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import io.github.sbracely.Jackson_Annotation_Example.common.DateTimeUtil;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

import java.time.LocalDateTime;

public class CustomDateSerializer extends StdSerializer<LocalDateTime> {

    protected CustomDateSerializer() {
        this(null);
    }

    protected CustomDateSerializer(Class<LocalDateTime> t) {
        super(t);
    }


    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        gen.writeString(DateTimeUtil.FORMATTER.format(value));
    }
}
