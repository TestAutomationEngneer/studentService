package com.example;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.MappedEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Schema(description="Actor business model")
@Entity
public class Actor
 {
     @GeneratedValue @Id
     @Nullable
     private Long id;
     @NotBlank @Size(max = 20)
     private String firstname;
     @NotBlank @Size(max = 20)
     private String lastname;
     @NotBlank
     private Long rating;

     public Long getRating() {
         return rating;
     }

     public void setRating(Long rating) {
         this.rating = rating;
     }

     public Actor(@Nullable Long id, String firstname, String lastname, Long rating) {
         this.id = id;
         this.firstname = firstname;
         this.lastname = lastname;
         this.rating = rating;
     }

     public Actor(String firstname, String lastname) {
         this.id = null;
         this.firstname = firstname;
         this.lastname = lastname;
     }

     public Actor() {
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

     @Override
     public String toString() {
         return "Actor{" +
                 "id=" + id +
                 ", firstname='" + firstname + '\'' +
                 ", lastname='" + lastname + '\'' +
                 ", rating=" + rating +
                 '}';
     }
 }
