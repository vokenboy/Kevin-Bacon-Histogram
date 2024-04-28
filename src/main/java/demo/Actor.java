package main.java.demo;

import java.util.HashSet;
import java.util.Set;

public class Actor {
    private String name;
    private Set<Movie> movies;

    public Actor(String name) {
        this.name = name;
        this.movies = new HashSet<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }


    // Getters and setters
    public String getName() {
        return name;
    }

    public Set<Movie> getMovies() {
        return new HashSet<>(movies); // Returning a copy to preserve encapsulation
    }

}
