package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    // Number of vertices
    private static final int vertices;
    private static final List<List<Integer>> adjacencyList;

    static {
        vertices = 6;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    public static List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public static void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
    }

    public static int getTotalVertex() {
        return vertices;
    }

}
