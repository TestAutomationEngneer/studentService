package com.example.service;

import com.example.Student;
import com.example.repository.StudentRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class StudentService {


    @Inject
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }


    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }


    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
