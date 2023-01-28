package com.example;

import io.micronaut.http.annotation.*;

@Controller("/actorServiceMicronaut")
public class ActorServiceMicronautController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Actor Service Micronaut is UP and RUNNING";
    }
}