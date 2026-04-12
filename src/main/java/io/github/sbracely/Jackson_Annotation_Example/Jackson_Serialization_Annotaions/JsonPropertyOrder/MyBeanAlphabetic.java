package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
public class MyBeanAlphabetic {
    public int id;
    public String name;

    public MyBeanAlphabetic(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
