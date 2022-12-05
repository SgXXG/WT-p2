package by.bsuir.lab4.connection;

import java.util.ResourceBundle;

class ConnectionProperties {

    private static ConnectionProperties instance;

    private String dbDriver;
    private String dbPort;
    private String dbHost;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private String dbEncoding;
    private int dbPoolSize;
    private String url;

    private ConnectionProperties() {

        ResourceBundle resource = ResourceBundle.getBundle("DataBaseProperties");
        dbDriver = resource.getString("jdbc.driver");
        dbName = resource.getString("jdbc.name");
        dbPassword = resource.getString("jdbc.password");
        dbHost = resource.getString("jdbc.host");
        dbUser = resource.getString("jdbc.username");
        dbPort = resource.getString("jdbc.port");
        dbPoolSize = Integer.parseInt(resource.getString("jdbc.poolsize"));
        dbEncoding = resource.getString("jdbc.encoding");
        url = resource.getString("jdbc.url");
    }

    static ConnectionProperties getInstance() {
        if (instance == null) {
            instance = new ConnectionProperties();
        }
        return instance;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPassword;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbEncoding() {
        return dbEncoding;
    }

    public int getDbPoolSize() {
        return dbPoolSize;
    }

    public String getUrl() {
        return url;
    }
}
