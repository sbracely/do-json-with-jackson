package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class UserWithRef {
    public int id;
    public String name;

    @JsonManagedReference
    public List<ItemWithRef> userItems;
}
