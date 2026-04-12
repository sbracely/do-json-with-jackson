package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends StdSerializer<Date> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    protected CustomDateSerializer() {
        this(null);
    }

    protected CustomDateSerializer(Class<Date> t) {
        super(t);
    }


    @Override
    public void serialize(Date value, JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        gen.writeString(dateFormat.format(value));
    }
}
