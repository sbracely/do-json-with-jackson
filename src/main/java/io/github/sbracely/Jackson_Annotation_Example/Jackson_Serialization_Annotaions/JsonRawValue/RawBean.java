package io.github.sbracely.Jackson_Annotation_Example.Jackson_Serialization_Annotaions.JsonRawValue;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawBean {
    private String name;

    private String json;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonRawValue
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public RawBean(String name, String json) {
        this.name = name;
        this.json = json;
    }
}
