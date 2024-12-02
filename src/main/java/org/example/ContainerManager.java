package org.example;

import java.util.ArrayList;
//Q1
/**
 *  Your Name:Siew Ya Huai
 *  Class Group:SD2b
 */
public class ContainerManager {    // Interfaces
    private ArrayList<IMeasurableContainer> containers;

    public ContainerManager(){
        containers = new ArrayList<>();
    }

    public void add(IMeasurableContainer container){
        containers.add(container);
    }

    public double totalWeight(){
        double total = 0;

        for(IMeasurableContainer container : containers){
            total += container.weight();
        }
        return total;
    }

    public double totalRectangularVolume(){
        double total = 0;

        for (IMeasurableContainer container : containers){
            total += container.rectangularVolume();
        }

        return total;
    }

    public void clearAll(){
        containers.clear();
    }

    public ArrayList<IMeasurableContainer> getAllContainers() {
        return containers;
    }
}


