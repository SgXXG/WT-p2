package main.java.by.bsuir.WT.lab2.service.validation;

import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;
import main.java.by.bsuir.WT.lab2.entity.criteria.SearchCriteria;

import java.util.Arrays;
import java.util.Set;

public class Validator {

    public static boolean validCriteria(Criteria criteria) {
        return switch (criteria.getGroupSearchName()) {
        case "Kettle" -> doesCriteriaExists(criteria, SearchCriteria.Kettle.class);
        case "Laptop" -> doesCriteriaExists(criteria, SearchCriteria.Laptop.class);
        case "Oven" -> doesCriteriaExists(criteria, SearchCriteria.Oven.class);
        case "Refrigerator" -> doesCriteriaExists(criteria, SearchCriteria.Refrigerator.class);
        case "Speakers" -> doesCriteriaExists(criteria, SearchCriteria.Speakers.class);
        case "TabletPC" -> doesCriteriaExists(criteria, SearchCriteria.TabletPC.class);
        case "VacuumCleaner" -> doesCriteriaExists(criteria, SearchCriteria.VacuumCleaner.class);
        default -> false;
        };
    }

    /**
     * Compares criteria to search criteria available for an appliance.
     * 
     * @param criteria criteria to search for
     * @param e        all search criteria available for an appliance
     * @return true if appliance has all of criteria
     */
    private static boolean doesCriteriaExists(Criteria criteria, Class<? extends Enum<?>> e) {
        Set<String> properties = criteria.getCriteria().keySet();
        String[] arr = Arrays.stream(e.getEnumConstants()).map(Enum::toString).toArray(String[]::new);
        return Arrays.asList(arr).containsAll(properties);
    }

}
