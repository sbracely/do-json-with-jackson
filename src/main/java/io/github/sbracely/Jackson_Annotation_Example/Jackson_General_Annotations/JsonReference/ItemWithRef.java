package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonReference;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ItemWithRef {
    public int id;
    public String itemName;

    @JsonBackReference
    public UserWithRef owner;
}
