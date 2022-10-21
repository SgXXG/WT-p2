package main.java.by.bsuir.WT.lab2.service.impl;

import main.java.by.bsuir.WT.lab2.dao.ApplianceDAO;
import main.java.by.bsuir.WT.lab2.dao.DAOFactory;
import main.java.by.bsuir.WT.lab2.entity.Appliance;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;
import main.java.by.bsuir.WT.lab2.service.ApplianceService;
import main.java.by.bsuir.WT.lab2.service.validation.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ApplianceServiceImpl implements ApplianceService {

    /**
     * Finds all appliances that fit the criteria if criteria are valid.
     * @param criteria
     * @return list of found appliances
     */
    @Override
    public List<Appliance> find(Criteria criteria) {
        if (Validator.validCriteria(criteria)) {
            ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
            return applianceDAO.find(criteria);
        }
        else
            return null;
    }

    @Override
    public List<Appliance> sort(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        appliances.sort(comparator);
        return appliances;
    }

    @Override
    public List<Appliance> sort(Comparator<Appliance> comparator, List<Appliance> appliances) {
        appliances.sort(comparator);
        return appliances;
    }

    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator, List<Appliance> appliances) {
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Override
    public List<Appliance> getMax(Comparator<Appliance> comparator) {
        List<Appliance> appliances = DAOFactory.getInstance().getApplianceDAO().parseAll();
        Appliance max = appliances.stream().max(comparator).orElse(null);
        if (max != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, max) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Override
    public List<Appliance> getMax(Comparator<Appliance> comparator, List<Appliance> appliances) {
        Appliance max = appliances.stream().max(comparator).orElse(null);
        if (max != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, max) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Override
    public void save(List<Appliance> appliances){
        DAOFactory.getInstance().getApplianceDAO().save(appliances);
    }
}
