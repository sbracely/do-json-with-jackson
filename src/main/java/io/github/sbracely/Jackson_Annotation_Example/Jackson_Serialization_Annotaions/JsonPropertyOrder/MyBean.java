package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "id"})
public class MyBean {
    public int id;
    public String name;

    public MyBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
