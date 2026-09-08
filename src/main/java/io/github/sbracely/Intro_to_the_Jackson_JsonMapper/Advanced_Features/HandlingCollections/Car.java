package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.HandlingCollections;

public class Car {
    private String type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
