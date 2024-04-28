package main.java.demo;

import main.java.utils.BaconHistogram;
import main.java.utils.FileReader;
import main.java.utils.Graph;
import main.java.utils.PathFinder;

import java.util.Scanner;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the movie database file (e.g., cast06.txt):");
        String fileName = scanner.nextLine();
        String filePath = "data/" + fileName;

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found in data directory: " + fileName);
            System.exit(1);
        }


        FileReader fileReader = new FileReader();
        fileReader.readFile(filePath);
        Graph graph = fileReader.getGraph();

        BaconHistogram.Histogram(filePath);

        PathFinder pathFinder = new PathFinder(graph, "Bacon, Kevin");
        System.out.println("Enter actor names, one per line (Type 'exit' to finish):");

        while (scanner.hasNextLine()) {
            String actorName = scanner.nextLine();
            if (actorName.equalsIgnoreCase("exit")) {
                break;
            }

            if (!graph.hasVertex(actorName)) {
                System.out.println(actorName + " not found in the database.");
                continue;
            }

            int baconNumber = pathFinder.distanceTo(actorName);
            if (baconNumber == Integer.MAX_VALUE) {
                System.out.println(actorName + " has a Bacon number of Infinity (no connection to Kevin Bacon).");
            }
            else {
                System.out.println(actorName + " has a Bacon number of " + baconNumber);
            }
        }

        scanner.close();
    }
}
