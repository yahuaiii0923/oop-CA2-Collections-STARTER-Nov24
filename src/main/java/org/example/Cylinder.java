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
    public double gwtheight(){
        return height;
    }

    public double getDiameter(){
        return diameter;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public double rectangularVolume() {
        double radius = diameter/2;
        return radius * height;
    }
}
