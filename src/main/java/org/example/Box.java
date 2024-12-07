package org.example;

//Q1
public class Box implements IMeasurableContainer{
    private double length, width, depth, weight;

    public Box(double length,double width, double depth,double weight){
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight =weight;

    }

    //getter
    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    public double getDepth(){
        return depth;
    }

    @Override
    public double weight(){
        return weight;
    }

    @Override
    public double rectangularVolume() {
        return length*width*depth;
    }
}
