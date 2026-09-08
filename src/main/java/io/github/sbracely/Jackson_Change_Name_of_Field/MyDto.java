package io.github.sbracely.Jackson_Change_Name_of_Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyDto {
    private String stringValue;

    @JsonProperty("strVal")
    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
