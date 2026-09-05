package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonSerialize;

import tools.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

public class Event {
    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public LocalDateTime eventDateTime;

    public Event(String name, LocalDateTime eventDateTime) {
        this.name = name;
        this.eventDateTime = eventDateTime;
    }
}
