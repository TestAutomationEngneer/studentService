package com.example.service;

import com.example.Actor;
import com.example.repository.ActorRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class ActorService {


    @Inject
    ActorRepository actorRepository;

    public List<Actor> getAllStudents() {
        return actorRepository.findAll();
    }

    public List<Actor> getAllActorsByName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }


    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }


    public Actor saveActor(Actor student) {
        return actorRepository.save(student);
    }
}
