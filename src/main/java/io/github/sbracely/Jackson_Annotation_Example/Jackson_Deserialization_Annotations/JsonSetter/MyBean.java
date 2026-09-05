package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonSetter;

import com.fasterxml.jackson.annotation.JsonSetter;

public class MyBean {
    public int id;
    private String name;

    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

    public String getTheName() {
        return name;
    }
}
