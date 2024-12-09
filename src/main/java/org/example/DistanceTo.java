package org.example;

public class DistanceTo implements Comparable<DistanceTo> {
    private String target;
    private int distance;

    public DistanceTo(String city, int dist)
    {
        target = city;
        distance = dist;
    }
    public String getTarget()
    {

        return target;
    }
    public int getDistance()
    {

        return distance;
    }

    @Override
    public int compareTo(DistanceTo other)
    {
        int distanceComparison = Integer.compare(this.distance, other.distance);
        if (distanceComparison != 0) {
            return distanceComparison; // Compare by distance first
        }
        return this.target.compareTo(other.target);
    }
}
