package io.github.sbracely.Jackson_Annotation_Example.Jackson_Deserialization_Annotations.JsonAnySetter;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class ExtendableBean {
    public String name;
    private Map<String, String> properties;

    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void add(String key, String value) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        properties.put(key, value);
    }
}
