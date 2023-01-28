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
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MicronautTest(environments = "test")
@Slf4j
class ActorServiceTest {


    @Inject
    ActorRepository actorRepository;

    @Test
    void shouldGetAllStudentsFromDB() {
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
    void shouldGetStudentByIdFromDB() {
        Long id = 1L;
        Optional<Actor> actualActor = actorRepository.findById(id);
        log.info(String.valueOf(actualActor));
        assertThat(actualActor.get().getFirstname()).isEqualTo("Brad");
    }
}