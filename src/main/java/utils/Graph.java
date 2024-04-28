package main.java.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    private static Map<String, Set<String>> adjacencyList;
    private int edgeCount;

    public Graph() {
        adjacencyList = new HashMap<>();
        edgeCount = 0;
    }

    public Graph(String filename, String delimiter) {
        adjacencyList = new HashMap<>();
        edgeCount = 0;
        loadFromFile(filename, delimiter);
    }

    private void loadFromFile(String filename, String delimiter) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(delimiter);
                if (parts.length < 2) continue; // Skip if not enough data

                // Temporarily store actors for each movie
                Set<String> actorsInMovie = new HashSet<>();

                for (int i = 1; i < parts.length; i++) {
                    String actor = parts[i].trim();
                    addVertex(actor); // Add the actor as a vertex
                    actorsInMovie.add(actor);
                }

                for (String actor1 : actorsInMovie) {
                    for (String actor2 : actorsInMovie) {
                        if (!actor1.equals(actor2)) {
                            addEdge(actor1, actor2);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        if (!hasVertex(vertex1)) {
            addVertex(vertex1);
        }
        if (!hasVertex(vertex2)) {
            addVertex(vertex2);
        }

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1); // For undirected graph
        edgeCount++; // Increment edge count only once per edge
    }

    public int V() {
        return adjacencyList.size();
    }

    public int E() {
        return edgeCount;
    }

    public static boolean hasVertex(String vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public Set<String> vertices() {
        return adjacencyList.keySet();
    }

    public Set<String> adjacentTo(String vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

}
