package com.example.repository;


import com.example.Actor;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

    @Override
    List<Actor> findAll();

    @Query(value = "select * from actor s where s.firstname = :firstName")
    List<Actor> findByFirstName(String firstName);
}
