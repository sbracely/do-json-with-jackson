package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonView;

import com.fasterxml.jackson.annotation.JsonView;

public class Item {
    @JsonView(Views.Public.class)
    public int id;

    @JsonView(Views.Public.class)
    public String itemName;

    @JsonView(Views.Internal.class)
    public String ownerName;

}
