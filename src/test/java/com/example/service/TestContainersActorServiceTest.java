package com.example.service;

import com.example.Actor;
import com.example.DBConector.DBConnector;
import com.example.DBConector.PostgresTestContainer;
import com.example.containers.PostgresContainer;
import com.example.repository.ActorRepository;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@MicronautTest(environments = "test")
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestContainersActorServiceTest {

    @Container
    private static final PostgreSQLContainer<?> postgres = PostgresContainer.getPostgresSQLContainer();

    @Inject
    ActorRepository actorRepository;

    @Inject
    private DBConnector dbConnector;

    @MockBean(DBConnector.class)
    DBConnector postgresConnection() {
        PostgresTestContainer dbConnection = new PostgresTestContainer();
        dbConnection.setUrl(postgres.getJdbcUrl());
        dbConnection.setUsername(postgres.getUsername());
        dbConnection.setPasswd(postgres.getPassword());
        return dbConnection;
    }


    @Test
    @Order(1)
    void shouldSaveActorToDbwithoutInitScript() {
        actorRepository.save(new Actor(11L, "Nicole", "Kidman", 12L));
        actorRepository.save(new Actor(12L, "Bruce", "Willis", 22L));
        actorRepository.save(new Actor(13L, "Tom", "Hanks", 8L));
        actorRepository.save(new Actor(14L, "Deni", "Moore", 32L));

        List<Actor> allActors = actorRepository.findAll();
        log.info(String.valueOf(allActors));
        //assertThat(allActors).hasSize(4);
        assertThat(allActors).hasSize(7);
        assertThat(allActors.get(0).getFirstname())
                .isEqualTo("Brad");
        assertThat(allActors.get(1).getFirstname())
                .isEqualTo("Angelina");
        assertThat(allActors.get(2).getFirstname())
                .isEqualTo("Salma");
    }


    @Test
    @Order(2)
    void shouldGetStudentByIdFromDB() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    @Order(3)
    void shouldSaveActorToDbWithInitTestData() {

        List<Actor> allActors = actorRepository.findAll();
        log.info(String.valueOf(allActors));
        assertThat(allActors).hasSize(3);
        assertThat(allActors.get(0).getFirstname())
                .isEqualTo("Brad");
        assertThat(allActors.get(1).getFirstname())
                .isEqualTo("Angelina");
        assertThat(allActors.get(2).getFirstname())
                .isEqualTo("Salma");
    }








    @Test
    void shouldGetStudentByIdFromDB1() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB2() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB3() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB4() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB5() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB6() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB7() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB8() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB9() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }
    @Test
    void shouldGetStudentByIdFromDB10() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB20() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB30() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB40() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB50() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB60() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB70() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB80() {
        Long id = 11L;

        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

    @Test
    void shouldGetStudentByIdFromDB90() throws InterruptedException {
        Long id = 11L;

        Thread.sleep(20000);
        actorRepository.save(new Actor(id, "Nicole", "Kidman", 12L));
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Nicole");
    }

}