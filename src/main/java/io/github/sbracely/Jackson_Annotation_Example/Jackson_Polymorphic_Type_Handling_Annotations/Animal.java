package io.github.sbracely.Jackson_Annotation_Example.Jackson_Polymorphic_Type_Handling_Annotations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
public class Animal {
    public String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }
}
