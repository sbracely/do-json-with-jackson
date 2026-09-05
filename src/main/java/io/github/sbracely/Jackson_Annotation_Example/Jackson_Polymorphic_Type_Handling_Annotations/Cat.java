package io.github.sbracely.Jackson_Annotation_Example.Jackson_Polymorphic_Type_Handling_Annotations;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("cat")
public class Cat extends Animal {
    boolean likesCream;
    public int lives;

    public Cat() {
    }

    public Cat(String name) {
        super(name);
    }
}
