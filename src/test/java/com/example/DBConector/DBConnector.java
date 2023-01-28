package com.example.DBConector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DBConnector {
    public abstract Connection getConnectionToDB(String dbProfile) throws SQLException;

    public abstract void setUrl(String url);

    protected Properties setDbProperties(String username, String passwd) {
        final Properties dbProperties = new Properties();
        dbProperties.setProperty("user", username);
        dbProperties.setProperty("password", passwd);
        return dbProperties;
    }
}
