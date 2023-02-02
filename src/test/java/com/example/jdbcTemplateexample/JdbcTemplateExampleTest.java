package com.example.jdbcTemplateexample;

import com.example.Actor;
import com.example.DBConector.DBConnector;
import com.example.DBConector.PostgresTestContainer;
import com.example.containers.PostgresContainer;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;


@Testcontainers
@MicronautTest(environments = "test")
@Slf4j
public class JdbcTemplateExampleTest {

    @Container
    private static final PostgreSQLContainer<?> postgres = PostgresContainer.getPostgresSQLContainer();

    @Inject
    private DBConnector dbConnector;

    @Inject
    private DataSource postgresDataSource;

    private JdbcTemplate jdbcTemplate;

    @MockBean(DBConnector.class)
    DBConnector postgresConnection() {
        PostgresTestContainer dbConnection = new PostgresTestContainer();
        dbConnection.setUrl(postgres.getJdbcUrl());
        dbConnection.setUsername(postgres.getUsername());
        dbConnection.setPasswd(postgres.getPassword());
        return dbConnection;
    }

    @Test
    void getAllActorsFromDBBasedOnTestContainersAndJDBCTemplate() {
        jdbcTemplate = new JdbcTemplate(postgresDataSource);
        await().atMost(10, TimeUnit.SECONDS)
                .until(this::isRecordLoaded);

        var dbResultsSize = this.getLoadedRecords().size();
        var dbResults = this.getLoadedRecords();

        assertThat(dbResultsSize).isEqualTo(3);
       assertThat(dbResults.get(0).get("firstname")).isEqualTo("Brad");
    }

    @Test
    void getSingleActorsFromDBBasedOnTestContainersAndJDBCTemplate() {
        jdbcTemplate = new JdbcTemplate(postgresDataSource);
        await().atMost(10, TimeUnit.SECONDS)
                .until(this::isRecordLoaded);

        var dbResultsSize = this.getLoadedRecords().size();
        var dbResults = this.getSingleRecord();

        assertThat(dbResultsSize).isEqualTo(3);
        assertThat(dbResults).isEqualTo("Brad");

    }

    private boolean isRecordLoaded() {
        return jdbcTemplate.queryForList("Select * from actor").size()>1;
    }

    private List<Map<String, Object>> getLoadedRecords() {
        return jdbcTemplate.queryForList("Select * from actor");
    }

    private String getSingleRecord() {
        return jdbcTemplate.queryForObject("Select firstname from actor where id=1", String.class);
    }
}



