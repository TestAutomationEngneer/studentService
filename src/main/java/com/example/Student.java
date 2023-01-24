package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.MappedEntity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Student
 {
     @GeneratedValue @Id
     @Nullable
     private Long id;
     @NotBlank @Size(max = 20)
     private String firstname;
     @NotBlank @Size(max = 20)
     private String lastname;

     public Student(@Nullable Long id, String firstname, String lastname) {
         this.id = id;
         this.firstname = firstname;
         this.lastname = lastname;
     }

     public Student(String firstname, String lastname) {
         this.id = null;
         this.firstname = firstname;
         this.lastname = lastname;
     }

     public Student() {
     }

     @Nullable
     public Long getId() {
         return id;
     }

     public void setId(@Nullable Long id) {
         this.id = id;
     }

     public String getFirstname() {
         return firstname;
     }

     public void setFirstname(String firstname) {
         this.firstname = firstname;
     }

     public String getLastname() {
         return lastname;
     }

     public void setLastname(String lastname) {
         this.lastname = lastname;
     }
 }
