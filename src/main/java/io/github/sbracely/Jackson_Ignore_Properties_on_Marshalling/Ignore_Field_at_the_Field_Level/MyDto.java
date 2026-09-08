package io.github.sbracely.Jackson_Ignore_Properties_on_Marshalling.Ignore_Field_at_the_Field_Level;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyDto {
    private String stringValue;
    @JsonIgnore
    private int intValue;
    private boolean boolValue;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public boolean isBoolValue() {
        return boolValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    @Override
    public String toString() {
        return "MyDto{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", boolValue=" + boolValue +
                '}';
    }
}
