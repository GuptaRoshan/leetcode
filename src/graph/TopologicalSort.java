package graph;

import java.util.*;

public class TopologicalSort {


    public static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : Graph.getAdjacencyList().get(v)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }


    public static List<Integer> topologicalSortDFS() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[Graph.getTotalVertex()];

        // Looping if the graphs are disconnected
        for (int i = 0; i < Graph.getTotalVertex(); i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static List<Integer> topologicalSortBFS() {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[Graph.getTotalVertex()];

        // Calculate in-degrees for all vertices
        for (int i = 0; i < Graph.getTotalVertex(); i++) {
            for (int neighbor : Graph.getAdjacencyList().get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Initialize a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        // Add vertices with in-degree 0 to the queue
        for (int i = 0; i < Graph.getTotalVertex(); i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            // Reduce the in-degree of neighbors and enqueue those with in-degree 0
            for (int neighbor : Graph.getAdjacencyList().get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {
        Graph.addEdge(5, 2);
        Graph.addEdge(5, 0);
        Graph.addEdge(4, 0);
        Graph.addEdge(4, 1);
        Graph.addEdge(2, 3);
        Graph.addEdge(3, 1);
        System.out.println("Topological Sort Order DFS: " + topologicalSortDFS());
        System.out.println("Topological Sort Order BFS: " + topologicalSortBFS());
    }

}
