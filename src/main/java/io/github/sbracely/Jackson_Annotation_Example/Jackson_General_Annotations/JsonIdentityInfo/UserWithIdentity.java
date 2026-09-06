package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserWithIdentity {
    private Integer id;
    public String name;
    public List<ItemWithIdentity> userItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
