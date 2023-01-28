package com.example;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "Actor Service Micronaut",
            version = "1.0",
            description = "My API",
            license = @License(name = "Apache 2.0", url = "https://actor.bar")
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}