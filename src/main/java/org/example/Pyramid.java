package org.example;

public class Pyramid implements IMeasurableContainer {
    private double length, sideLength, weight;

    public Pyramid(double length, double sideLength, double weight) {
        this.length = length;
        this.sideLength = sideLength;
        this.weight = weight;
    }

    // getter methods
    public double getLength() {
        return length;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return length*sideLength*length;
    }
}
