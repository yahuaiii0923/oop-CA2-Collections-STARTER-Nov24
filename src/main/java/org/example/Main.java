package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ContainerManager manager = new ContainerManager();

        manager.add(new Box(8,6,3,9.1
        ));
        manager.add(new Pyramid(2.4,5,3));
        manager.add(new Cylinder(15,4.3,6.4));
        manager.add(new Box(5.7,6,5,7));
        manager.add(new Pyramid(6.8,5,3));
        manager.add(new Cylinder(6,9,4.3));

        System.out.println("Total weight: " + manager.totalWeight());
        System.out.println("Total rectangular volume: " + manager. totalRectangularVolume());

        ArrayList<IMeasurableContainer> containers = manager.getAllContainers();
        for (IMeasurableContainer container : containers){
            if (container instanceof Box box){
                System.out.println("Box - Length: " + box.getLength()+
                        ", Width: " + box.getWidth() +
                        ", Depth: " + box.getDepth()+
                        ", Weight: " + box.weight());
            }else if(container instanceof Pyramid pyramid){
                System.out.println("Pyramid - Length: " + pyramid.getLength() +
                        ", Side Length: " + pyramid.getSideLength() +
                        ", Weight: " + pyramid.weight());
            }else if (container  instanceof Cylinder cylinder){
                System.out.println("Cylinder - Height: " + cylinder.getHeight() +
                        ", Diameter: " + cylinder.getDiameter() +
                        ", Weight: " + cylinder.weight());
            }
        }
    }
}