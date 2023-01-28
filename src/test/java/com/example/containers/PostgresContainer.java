package com.example.containers;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class PostgresContainer extends PostgreSQLContainer<PostgresContainer> {


    private static final String MYPOSTGRESIMAGE = "postgres:latest" ;
    private static final String MYTESTDATABASENAME = "actor";
    private static final String USERNAME = "postgres";
    private static final String PASSWD = "postgres";
    private static final Integer DB_PORT = 5432;

    public static PostgreSQLContainer<?> getPostgresSQLContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse(MYPOSTGRESIMAGE))
                .withDatabaseName(MYTESTDATABASENAME)
                .withUsername(USERNAME)
                .withPassword(PASSWD)
                .withExposedPorts(DB_PORT);
    }
}
