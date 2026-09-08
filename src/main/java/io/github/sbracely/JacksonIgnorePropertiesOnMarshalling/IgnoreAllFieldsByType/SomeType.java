package io.github.sbracely.JacksonIgnorePropertiesOnMarshalling.IgnoreAllFieldsByType;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class SomeType {
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
