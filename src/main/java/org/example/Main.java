package org.example;

public class Main {
    public static void main(String[] args) {
        ContainerManager manager = new ContainerManager();

        manager.add(new Box(10,5,8,2.5));
        manager.add(new Pyramid(3.8,8,5));
        manager.add(new Cylinder(20,8,7.3));
        manager.add(new Box(15,8,10,10));
        manager.add(new Pyramid(8.8,12,6.7));
        manager.add(new Cylinder(5,2,3));

        System.out.println("Total weight: " + manager.totalWeight());
        System.out.println("Total rectangular volume: " + manager.totalRectangularVolume());
        System.out.println("Full list of containers: " + manager.getAllContainers());
    }
}