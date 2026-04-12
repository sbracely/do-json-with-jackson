package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JacksonInject;

import com.fasterxml.jackson.annotation.JacksonInject;

public class BeanWithInject {
    @JacksonInject
    public int id;

    public String name;
}
