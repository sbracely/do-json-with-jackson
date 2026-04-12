package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonGetter;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MyBean {
    public int id;
    private String name;

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
