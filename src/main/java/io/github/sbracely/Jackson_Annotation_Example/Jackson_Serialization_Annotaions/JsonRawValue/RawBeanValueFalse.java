package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonRawValue;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBeanValueFalse {
    public String name;

    @JsonRawValue(value = false)
    public String json;

    public RawBeanValueFalse(String name, String json) {
        this.name = name;
        this.json = json;
    }
}
