package main.java.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import main.java.demo.Actor;
import main.java.demo.Movie;

public class FileReader {

    private Map<String, Movie> movies;
    private Map<String, Actor> actors;

    public FileReader() {
        movies = new HashMap<>();
        actors = new HashMap<>();
    }

    public void readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private void processLine(String line) {
        String[] parts = line.split("/");
        if (parts.length < 2) return; // Skip if there's no actor in the line

        String movieTitle = parts[0].trim();
        Movie movie = movies.computeIfAbsent(movieTitle, Movie::new);

        for (int i = 1; i < parts.length; i++) {
            String actorName = parts[i].trim();
            Actor actor = actors.computeIfAbsent(actorName, Actor::new);
            movie.addActor(actor);
            actor.addMovie(movie);
        }
    }
    public Graph getGraph() {
        Graph graph = new Graph();

        for (Movie movie : movies.values()) {
            String movieTitle = movie.getTitle();
            graph.addVertex(movieTitle);

            for (Actor actor : movie.getActors()) {
                String actorName = actor.getName();
                graph.addVertex(actorName);
                graph.addEdge(movieTitle, actorName);
            }
        }

        return graph;
    }
}
