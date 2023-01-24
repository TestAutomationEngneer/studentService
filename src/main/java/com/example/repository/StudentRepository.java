package com.example.repository;


import com.example.Student;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Override
    List<Student> findAll();

    @Query(value = "select * from student s where s.firstname = :firstName")
    List<Student> findByFirstName(String firstName);
}
