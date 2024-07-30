package com.dassault.graphql.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dassault.graphql.models.Movie;

import jakarta.annotation.PostConstruct;

@Repository
public class MovieRepository {
    private List<Movie> mockMovies;
    
    @PostConstruct
    public void initializeMockMovies() {
        mockMovies = new ArrayList<Movie>(List.of(        		
                new Movie(1, "The Matrix", 1999, List.of("Action", "Sci-Fi"), "The Wachowskis"),
                new Movie(2, "The Matrix Reloaded", 2003, List.of("Action", "Sci-Fi"), "The Wachowskis"),
                new Movie(3, "The Matrix Revolutions", 2003, List.of("Action", "Sci-Fi"), "The Wachowskis")
        )
        );
    }

    public Movie getById(Integer id) {
        return mockMovies.stream().filter(movie -> movie.id().equals(id)).findFirst().orElse(null);
    }

    public void addMovie(Movie movie) {
        mockMovies.add(movie);
    }
    
    public List<Movie> getAllMovies(){
    	return mockMovies;
    }
}
