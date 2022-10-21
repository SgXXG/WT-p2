package main.java.by.bsuir.WT.lab2.entity;

public class Oven extends Appliance {
    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double width;

    public Oven() {
    }

    public Oven(String name, double price, int powerConsumption, int weight, int capacity, int depth, double height,
            double width) {
        super(name, price);
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Oven\nName = " + name + ", Price = " + price + ", PowerConsumption = " + powerConsumption
                + ", Weight = " + weight + ", Capacity = " + capacity + ", Depth = " + depth + ", Height = " + height
                + ", Width = " + width;
    }
}
