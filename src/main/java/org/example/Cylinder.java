package org.example;

public class Cylinder implements IMeasurableContainer {
    private double height, diameter, weight;

    public Cylinder(double height, double diameter, double weight) {
        this.height = height;
        this.diameter = diameter;
        this.weight = weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return height*diameter*diameter;
    }
}
