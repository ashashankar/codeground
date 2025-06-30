package com.myplayground.DesignPatterns.Prototype;

public class PackageConfig implements Prototype<PackageConfig>{

    private String type;
    private String color;
    private String label;
    public PackageConfig(String type, String color, String label) {
        this.type = type;
        this.color = color;
        this.label = label;
    }


    @Override
    public PackageConfig clone() {
        return new PackageConfig(this.type, this.color, this.label);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Package type "+ this.type + " color "+ color + " label "+ label;
    }
}
