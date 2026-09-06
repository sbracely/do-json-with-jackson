package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonFilter;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("myFilter")
public class BeanWithFilter {
    public int id;
    public String name;
}
