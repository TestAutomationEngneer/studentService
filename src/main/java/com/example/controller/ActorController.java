package com.example.controller;

import com.example.Actor;
import com.example.service.ActorService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


import java.util.List;
import java.util.Optional;

import static io.micronaut.http.MediaType.APPLICATION_JSON;


@Controller(value = "/actor")
public class ActorController {


     private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @Get("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Actors list", operationId = "actor_list", description = "desc actor list")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Actor.class, type = "array")
            )
    )
    public List<Actor> getAll() {
        return  actorService.getAllStudents();
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Single Actor", operationId = "single_actor", description = "desc actor list")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Actor.class)
            )
    )
    public Optional<Actor> getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @Post("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Save actor", operationId = "save_actor", description = "desc actor save")
    @ApiResponse(
            responseCode = "201",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Actor.class, type = "array")
            )
    )
    public HttpResponse<Actor> createActor(@Body Actor student) {
        Actor savedStudent = actorService.saveActor(student);
        return HttpResponse.status(HttpStatus.CREATED).body(savedStudent);
    }

}