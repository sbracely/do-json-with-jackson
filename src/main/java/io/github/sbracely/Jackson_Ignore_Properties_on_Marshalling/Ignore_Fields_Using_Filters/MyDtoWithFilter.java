package io.github.sbracely.Jackson_Ignore_Properties_on_Marshalling.Ignore_Fields_Using_Filters;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("myFilter")
public class MyDtoWithFilter {
    private int intValue;
    private String string;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
