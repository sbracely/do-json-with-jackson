package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonDeserialize;

import tools.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

public class Event {
    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public LocalDateTime eventDateTime;
}
