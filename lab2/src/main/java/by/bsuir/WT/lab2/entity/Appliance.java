package main.java.by.bsuir.WT.lab2.entity;

public class Appliance {
    protected double price;
    protected String name;

    public Appliance() {
    }

    public Appliance(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
