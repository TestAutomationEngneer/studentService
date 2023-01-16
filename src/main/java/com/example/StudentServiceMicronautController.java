package com.example;

import io.micronaut.http.annotation.*;

@Controller("/studentServiceMicronaut")
public class StudentServiceMicronautController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Student Service Micronaut is UP and RUNNING";
    }
}