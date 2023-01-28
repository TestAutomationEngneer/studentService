package com.example.DBConector;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class PostgresTestContainer extends DBConnector{

    @Setter
    private String url;
    @Setter
    private String username;
    @Setter
    private String passwd;

    @Override
    public Connection getConnectionToDB(String dbProfile) throws SQLException {
        log.info("Postgres testContainer started");
        return DriverManager.getConnection(url, setDbProperties(username, passwd));

    }
}
