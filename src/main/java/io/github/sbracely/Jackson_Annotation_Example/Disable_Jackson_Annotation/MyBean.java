package io.github.sbracely.Jackson_Annotation_Example.Disable_Jackson_Annotation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyBean {
    public int id;
    public String name;
}
