package com.example.controller;

import com.example.Actor;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


@MicronautTest
class ActorControllerTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:8090";
        RestAssured.basePath = "/actor";

    }
    @Test
    void getAllActors() {
        List<Actor> resultActors = given().log().all()
                .when()
                .get("/all")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<Actor>>() {});


        //List<Actor> emptyList = new ArrayList<>();
        //emptyList = null;
        assertThat(resultActors).isNotNull();
        assertThat(resultActors).hasSize(4);

    }

    @Test
    void getSingleActorById() {

        Long id = 3L;
        Actor resultActor = given().log().all()
                .pathParam("id", id)
                .when()
                .get("/{id}")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(new TypeRef<Actor>() {});


        String expectedFirstName = "Salma";
        assertThat(resultActor).isNotNull();
        assertThat(resultActor.getFirstname()).isEqualTo(expectedFirstName);
    }

    @Test
    void saveNewActor() {
        assertThat(true).isEqualTo(true);
    }
}