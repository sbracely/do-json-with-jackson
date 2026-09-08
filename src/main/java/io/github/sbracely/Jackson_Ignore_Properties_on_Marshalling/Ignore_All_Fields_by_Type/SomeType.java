package io.github.sbracely.Jackson_Ignore_Properties_on_Marshalling.Ignore_All_Fields_by_Type;

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
