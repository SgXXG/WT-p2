package main.java.by.bsuir.WT.lab2.dao;

import main.java.by.bsuir.WT.lab2.entity.Appliance;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {

    /**
     * Finds appliances that fit certain criteria.
     * 
     * @param criteria a set of criteria
     * @return list of appliances that fit the criteria
     */
    List<Appliance> find(Criteria criteria); // Criteria criteria

    /**
     * Saves a list of appliances to a file.
     * 
     * @param appliences list of appliances to save
     */
    void save(List<Appliance> appliences);

    /**
     * Gets all appliances from a file.
     * 
     * @return list of all appliances
     */
    List<Appliance> parseAll();
}
