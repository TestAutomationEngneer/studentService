package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;


    public Student(){ }

    public Student(@NotNull String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstnameName() {
        return firstname;
    }

    public void setFirstnameName(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
                '}';
    }

}
