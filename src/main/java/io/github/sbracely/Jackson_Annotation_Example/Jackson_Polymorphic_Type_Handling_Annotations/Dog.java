package io.github.sbracely.Jackson_Annotation_Example.Jackson_Polymorphic_Type_Handling_Annotations;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("dog")
public class Dog extends Animal {
    public double barkVolume;

    public Dog() {
    }

    public Dog(String name) {
        super(name);
    }
}
