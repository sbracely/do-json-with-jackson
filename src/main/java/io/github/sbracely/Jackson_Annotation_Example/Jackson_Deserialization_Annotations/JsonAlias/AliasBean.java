package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAlias;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AliasBean {
    @JsonAlias({"fName", "f_name"})
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
