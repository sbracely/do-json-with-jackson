package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.sbracely.Jackson_Annotation_Example.common.DateTimeUtil;

import java.time.LocalDateTime;

public class Event {
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimeUtil.FORMAT_PATTERN)
    public LocalDateTime eventDateTime;
}
