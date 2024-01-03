package traversal;


import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private final int vertices;
    private final LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        /** For undirected graph **/
        adjacencyList[destination].add(source);
    }


    /**
     * Breadth-First Search (BFS) traversal
     **/
    public void bfsTraversal(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    /**
     * Depth-First Search (DFS) traversal
     **/

    public void dfsTraversal(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsRecursive(startVertex, visited);
    }

    private void dfsRecursive(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

}


class GraphTraversal {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);

        System.out.println("Breadth-First Search (BFS) Traversal:");
        graph.bfsTraversal(0);

        System.out.println("\n\nDepth-First Search (DFS) Traversal:");
        graph.dfsTraversal(0);
    }
}
