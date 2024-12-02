package org.example;
//Q1
public class Cylinder implements IMeasurableContainer{
    private double height,diameter,weight;

    public Cylinder(double height,double diameter,double weight){
        this.height = height;
        this.diameter = diameter;
        this.weight =weight;
    }

    //getter
    public double getHeight(){
        return height;
    }

    public double getDiameter(){
        return diameter;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return diameter * diameter * height;
    }
}
