package com.dassault.graphql.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dassault.graphql.models.Actor;

import jakarta.annotation.PostConstruct;

@Repository
public class ActorRepository {

    private List<Actor> mockActors;
    private MovieRepository movieRepository;

    public ActorRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    private void initializeMockActors() {
        mockActors = new ArrayList<>(List.of(
                new Actor(1, "Keanu Reeves",  List.of(movieRepository.getById(1), movieRepository.getById(2), movieRepository.getById(3))),
                new Actor(2, "Laurence Fishburne", List.of(movieRepository.getById(1), movieRepository.getById(2), movieRepository.getById(3))))
        );
    }

    public Actor getById(Integer id) {
        return mockActors
                .stream()
                .filter(actor -> actor.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}