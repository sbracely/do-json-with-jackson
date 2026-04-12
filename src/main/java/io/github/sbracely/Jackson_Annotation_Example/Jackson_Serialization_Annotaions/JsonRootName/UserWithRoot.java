package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonRootName;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user", namespace = "users")
public class UserWithRoot {
    public int id;
    public String name;

    public UserWithRoot(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
