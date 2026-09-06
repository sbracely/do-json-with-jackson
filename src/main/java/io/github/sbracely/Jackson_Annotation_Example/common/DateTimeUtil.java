package io.github.sbracely.Jackson_Annotation_Example.common;

import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String FORMAT_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT_PATTERN);
}
