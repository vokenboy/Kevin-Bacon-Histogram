package main.java.utils;

import java.util.Stack;

public class PathFinder {

    private ST<String, String>  prev = new ST<String, String>();
    private static ST<String, Integer> dist = new ST<String, Integer>();

    public PathFinder(Graph G, String s) {

        ListQueue<String> queue = new ListQueue<>();
        queue.enqueue(s);
        dist.put(s, 0);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            for (String w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    public static boolean hasPathTo(String v) {
        return dist.contains(v);
    }

    // return the length of the shortest path from v to s
    public static int distanceTo(String v) {
        if (!hasPathTo(v)) return Integer.MAX_VALUE;
        return dist.get(v);
    }

    public Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<String>();
        while (v != null && dist.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }
}