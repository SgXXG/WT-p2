package main.java.by.bsuir.WT.lab2.entity;

import main.java.by.bsuir.WT.lab2.entity.enums.OS;

public class Laptop extends Appliance {
    private double batteryCapacity;
    private OS os;
    private int memoryRom;
    private int systemMemory;
    private double cpu;
    private int displayInches;

    public Laptop() {
    }

    public Laptop(String name, double price, double batteryCapacity, OS os, int memoryRom, int systemMemory, double cpu,
            int displayInches) {
        super(name, price);
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public int getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(int memoryRom) {
        this.memoryRom = memoryRom;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public String toString() {
        return "Laptop\nName = " + name + ", Price = " + price + ", BatteryCapacity = " + batteryCapacity + ", Os = "
                + os + ", MemoryRom = " + memoryRom + ", SystemMemory = " + systemMemory + ", Cpu = " + cpu
                + ", DisplayInches = " + displayInches;
    }
}
