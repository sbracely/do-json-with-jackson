package io.github.sbracely.Jackson_Annotation_Example.Custom_Jackson_Annotation;

import java.time.LocalDateTime;

@CustomAnnotation
public class BeanWithCustomAnnotation {
    public int id;
    public String name;
    public LocalDateTime dateCreated;
}
