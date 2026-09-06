package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ItemWithIdentity {
    private Integer id;
    public String itemName;
    public UserWithIdentity owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
