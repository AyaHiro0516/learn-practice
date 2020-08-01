package org.ayahiro.practice.compiling_principle.lexical_analysis.utils;

public class Token {
    private String value;
    private String type;
    private int location;

    public Token() {
    }

    public Token(String value, String type, int location) {
        this.value = value;
        this.type = type;
        this.location = location;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
