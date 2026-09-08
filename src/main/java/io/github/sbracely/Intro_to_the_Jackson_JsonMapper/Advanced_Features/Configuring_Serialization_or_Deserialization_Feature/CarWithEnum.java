package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Configuring_Serialization_or_Deserialization_Feature;

public class CarWithEnum {
    public enum Color {
        RED, GREEN, BLUE, BLACK, WHITE
    }

    private Color color;
    private String type;

    public CarWithEnum() {
    }

    public CarWithEnum(Color color, String type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
