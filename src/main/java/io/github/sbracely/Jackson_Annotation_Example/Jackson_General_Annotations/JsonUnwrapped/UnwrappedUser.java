package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonUnwrapped;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class UnwrappedUser {
    public int id;

    @JsonUnwrapped
    public Name name;

    public static class Name {
        public String firstName;
        public String lastName;
    }
}
