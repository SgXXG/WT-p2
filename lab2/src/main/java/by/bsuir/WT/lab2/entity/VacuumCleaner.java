package main.java.by.bsuir.WT.lab2.entity;

public class VacuumCleaner extends Appliance {
    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner() {
    }

    public VacuumCleaner(String name, double price, double powerConsumption, String filterType, String bagType,
            String wandType, double motorSpeedRegulation, double cleaningWidth) {
        super(name, price);
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public String toString() {
        return "VacuumCleaner\nName = " + name + ", Price = " + price + ", PowerConsumption = " + powerConsumption
                + ", FilterType = " + filterType + ", BagType = " + bagType + ", WandType = " + wandType
                + ", MotorSpeedRegulation = " + motorSpeedRegulation + ", CleaningWidth = " + cleaningWidth;
    }
}
