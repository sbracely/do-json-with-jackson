package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonValue;

public class BeanWithEnum {
    private final String name;
    private final TypeEnumWithValue type;

    public String getName() {
        return name;
    }

    public TypeEnumWithValue getType() {
        return type;
    }

    public BeanWithEnum(String name, TypeEnumWithValue type) {
        this.name = name;
        this.type = type;
    }
}
