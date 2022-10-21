package main.java.by.bsuir.WT.lab2.dao;

import main.java.by.bsuir.WT.lab2.dao.impl.ApplianceDAOimpl;

/**
 * A factory for creating ApplianceDAO.
 */
public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return new ApplianceDAOimpl();
    }
}
