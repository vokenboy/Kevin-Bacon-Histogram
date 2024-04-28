package main.java.demo;

import main.java.utils.PathFinder;
import main.java.utils.Graph;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSTest {

    private Graph testGraph;
    private PathFinder pathFinder;

    @Before
    public void setUp() {
        testGraph = new Graph();

        testGraph.addEdge("Vertex1", "Vertex2");
        testGraph.addEdge("Vertex2", "Vertex3");
        testGraph.addEdge("Vertex3", "Vertex4");
    }


    @Test
    public void testActualPath() {
        pathFinder = new PathFinder(testGraph, "Vertex1");
        Iterable<String> actualPath = pathFinder.pathTo("Vertex3");

        List<String> pathList = new ArrayList<>();
        for (String v : actualPath) {
            pathList.add(v);
        }

        List<String> expectedPath = Arrays.asList("Vertex3", "Vertex2", "Vertex1");

        assertEquals(expectedPath, pathList);
    }
    @Test
    public void testDistance() {
        pathFinder = new PathFinder(testGraph, "Vertex1");
        int distance = PathFinder.distanceTo("Vertex3");

        // The expected distance from Vertex1 to Vertex3 is 2
        int expectedDistance = 2;
        assertEquals(expectedDistance, distance);
    }
}
