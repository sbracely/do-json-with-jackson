package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyBean {
    public int id;
    private String name;

    @JsonProperty("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @JsonProperty("name")
    public String getTheName() {
        return name;
    }
}
