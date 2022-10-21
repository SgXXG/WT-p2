package main.java.by.bsuir.WT.lab2.entity.criteria;

/**
 * Class containing enums of all appliances type that specify appliance's
 * criteria that can be searched for.
 */
public class SearchCriteria {
    public enum Oven {
        NAME("name"), PRICE("price"), POWER_CONSUMPTION("powerConsumption"), WEIGHT("weight"), CAPACITY("capacity"),
        DEPTH("depth"), HEIGHT("height"), WIDTH("width");

        private final String value;

        Oven(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Laptop {
        NAME("name"), PRICE("price"), BATTERY_CAPACITY("batteryCapacity"), OS("os"), MEMORY_ROM("memoryRom"),
        SYSTEM_MEMORY("systemMemory"), CPU("cpu"), DISPLAY_INCHES("displayInches");

        /**
         * String representation of criteria name.
         */
        private final String value;

        /**
         * Enum constructor specifying string representation.
         * 
         * @param value string representation of criteria name
         */
        Laptop(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Refrigerator {
        NAME("name"), PRICE("price"), POWER_CONSUMPTION("powerConsumption"), WEIGHT("weight"),
        FREEZER_CAPACITY("freezerCapacity"), OVERALL_CAPACITY("overallCapacity"), HEIGHT("height"), WIDTH("width");

        private final String value;

        Refrigerator(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum VacuumCleaner {
        NAME("name"), PRICE("price"), POWER_CONSUMPTION("powerConsumption"), FILTER_TYPE("filterType"),
        BAG_TYPE("bagType"), WAND_TYPE("wandType"), MOTOR_SPEED_REGULATION("motorSpeedRegulation"),
        CLEANING_WIDTH("cleaningWidth");

        private final String value;

        VacuumCleaner(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public static enum TabletPC {
        NAME("name"), PRICE("price"), BATTERY_CAPACITY("batteryCapacity"), DISPLAY_INCHES("displayInches"),
        MEMORY_ROM("memoryRom"), FLASH_MEMORY_CAPACITY("flashMemoryCapacity"), COLOR("Color");

        private final String value;

        TabletPC(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Speakers {
        NAME("name"), PRICE("price"), POWER_CONSUMPTION("powerConsumption"), NUMBER_OF_SPEAKERS("numberOfSpeakers"),
        FREQUENCY_RANGE_MIN("frequencyRangeMin"), FREQUENCY_RANGE_MAX("frequencyRangeMax"), CORD_LENGTH("cordLength");

        private final String value;

        Speakers(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Kettle {
        NAME("name"), PRICE("price"), POWER_CONSUMPTION("powerConsumption"), WATER_CAPACITY("waterCapacity"),
        COLOR("color");

        private final String value;

        Kettle(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private SearchCriteria() {
    }
}
