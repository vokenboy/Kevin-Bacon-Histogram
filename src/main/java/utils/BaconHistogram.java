package main.java.utils;
public class BaconHistogram {
    public static void Histogram(String filename) {
        // read in data and initialize graph
        Graph G = new Graph(filename, "/");
        System.out.println("Done reading movies and building graph");
        System.out.println("vertices = " + G.V());
        System.out.println("edges = " + G.E());

        // run breadth first search from Kevin Bacon
        String s = "Bacon, Kevin";
        PathFinder finder = new PathFinder(G, s);
        System.out.println("Done BFS");

        // compute histogram of Kevin Bacon numbers
        int MAX_BACON = 100;
        int[] hist = new int[MAX_BACON + 1];
        for (String actor : G.vertices()) {
            int bacon = finder.distanceTo(actor);
            if (bacon > MAX_BACON) {
                bacon = MAX_BACON; // Treat distances greater than MAX_BACON as Inf
            }
            hist[bacon]++;
        }

        // print out histogram
        for (int i = 0; i < MAX_BACON; i++) {
            if (hist[i] == 0) continue;
            System.out.printf("%3d %8d\n", i, hist[i]);
        }
        System.out.printf("Inf %8d\n", hist[MAX_BACON]);
    }
}