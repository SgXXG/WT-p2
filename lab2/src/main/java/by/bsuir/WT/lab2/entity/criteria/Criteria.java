package main.java.by.bsuir.WT.lab2.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private final String groupSearchName;
    private Map<String, Object> criteria = new HashMap<>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    /**
     * Adds a set of property and its desired value to map of criteria.
     * 
     * @param searchCriteria searched criteria
     * @param value          desired value
     */
    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }
}
