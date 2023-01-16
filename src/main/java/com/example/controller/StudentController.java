package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


import java.util.List;
import java.util.Optional;

import static io.micronaut.http.MediaType.APPLICATION_JSON;


@Controller(value = "/student")
public class StudentController {


     private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @Get("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Students list", operationId = "list_students", description = "desc student list")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Student.class, type = "array")
            )
    )
    public List<Student> getAll() {
        return  studentService.getAllStudents();
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Single Student", operationId = "single_students", description = "desc student list")
    @ApiResponse(
            responseCode = "200",
            content = @Content(
                    mediaType = APPLICATION_JSON,
                    schema = @Schema(implementation = Student.class)
            )
    )
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

//    @Post("/create")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Operation(summary = "Save student", operationId = "save_student", description = "desc student save")
//    @ApiResponse(
//            responseCode = "201",
//            content = @Content(
//                    mediaType = APPLICATION_JSON,
//                    schema = @Schema(implementation = Student.class, type = "array")
//            )
//    )
//    public HttpResponse<Student> createStudent(@Body Student student) {
//                studentService.saveStudent(student);
//        return HttpResponse.status(HttpStatus.CREATED).body(student);
//    }

}