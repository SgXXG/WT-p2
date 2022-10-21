package main.java.by.bsuir.WT.lab2.entity;

import main.java.by.bsuir.WT.lab2.entity.enums.Color;

public class TabletPC extends Appliance {
    private double batteryCapacity;
    private int displayInches;
    private double memoryRom;
    private double flashMemoryCapacity;
    private Color color;

    public TabletPC() {
    }

    public TabletPC(String name, double price, double batteryCapacity, int displayInches, double memoryRom,
            double flashMemoryCapacity, Color color) {
        super(name, price);
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public double getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(double memoryRom) {
        this.memoryRom = memoryRom;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TabletPC\nName = " + name + ", Price = " + price + ", BatteryCapacity = " + batteryCapacity
                + ", DisplayInches = " + displayInches + ", MemoryRom = " + memoryRom + ", FlashMemoryCapacity = "
                + flashMemoryCapacity + ", Color = " + color;
    }
}
