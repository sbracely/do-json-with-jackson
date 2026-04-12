package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import tools.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Event {
    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public Event(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}
