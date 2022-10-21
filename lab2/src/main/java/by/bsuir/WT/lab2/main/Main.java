package main.java.by.bsuir.WT.lab2.main;

import main.java.by.bsuir.WT.lab2.entity.*;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;
import main.java.by.bsuir.WT.lab2.entity.criteria.SearchCriteria;
import main.java.by.bsuir.WT.lab2.service.ApplianceService;
import main.java.by.bsuir.WT.lab2.service.ServiceFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplianceService service = ServiceFactory.getInstance().getApplianceService();
        List<Appliance> list = new ArrayList<Appliance>();

        Criteria kettleCriteria = new Criteria(SearchCriteria.Kettle.class.getSimpleName());
        List<Appliance> kettles = service.find(kettleCriteria);
        list.addAll(kettles);
        if (kettles != null) {
            List<Appliance> kettlesOrderedByName = service.sort(Comparator.comparing(Appliance::getName), kettles);
            System.out.println("\nВсе чайники(в алфавитном порядке): ");
            PrintApplianceInfo.print(kettlesOrderedByName);
        }

        Criteria laptopCriteria = new Criteria(SearchCriteria.Laptop.class.getSimpleName());
        List<Appliance> laptops = service.find(laptopCriteria);
        list.addAll(laptops);

        Criteria refrigeratorCriteria = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
        List<Appliance> refrigerators = service.find(refrigeratorCriteria);
        list.addAll(refrigerators);

        Criteria vcCriteria = new Criteria(SearchCriteria.VacuumCleaner.class.getSimpleName());
        List<Appliance> vcs = service.find(vcCriteria);
        list.addAll(vcs);

        List<Appliance> minPriceAppliances = service.getMin(Comparator.comparing(Appliance::getPrice), list);
        if (minPriceAppliances != null) {
            System.out.println("\nСамый дешевый прибор: ");
            PrintApplianceInfo.print(minPriceAppliances);
        }

        List<Appliance> maxPriceAppliances = service.getMax(Comparator.comparing(Appliance::getPrice), list);
        if (maxPriceAppliances != null) {
            System.out.println("\nСамый дорогой прибор: ");
            PrintApplianceInfo.print(maxPriceAppliances);
        }

    }
}