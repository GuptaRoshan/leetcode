package graph;


import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        this.val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        this.val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        this.val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public static Node cloneGraph(Node node) {
        HashMap<Integer, Node> clones = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        if (node == null) return node;

        queue.add(node);
        clones.put(node.val, new Node(node.val, new ArrayList<Node>()));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Node currentClone = clones.get(currentNode.val);

            for (Node neighbor : currentNode.neighbors) {
                if (!clones.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    clones.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));
                }
                currentClone.neighbors.add(clones.get(neighbor.val));
            }
        }

        return clones.get(node.val);
    }

    public static Node cloneGraphDFSHelper(Node node, HashMap<Integer, Node> clones) {

        if (clones.containsKey(node.val)) {
            return clones.get(node.val);
        }

        if (!clones.containsKey(node.val)) {
            clones.put(node.val, new Node(node.val, new ArrayList<>()));
            for (Node currNode : node.neighbors) {
                clones.get(node.val).neighbors.add(cloneGraphDFSHelper(currNode, clones));
            }
        }

        return clones.get(node.val);
    }

    public static Node cloneGraphDFS(Node node) {
        HashMap<Integer, Node> clones = new HashMap<>();
        if (node == null) return node;

        return cloneGraphDFSHelper(node, clones);
    }

    public static void main(String[] args) {
        Node vertext1 = new Node(1);
        Node vertext2 = new Node(2);
        Node vertext3 = new Node(3);
        Node vertext4 = new Node(4);

        //adding vertex1 neighbors
        vertext1.neighbors.add(vertext2);
        vertext1.neighbors.add(vertext4);

        //adding vertex2 neighbors
        vertext2.neighbors.add(vertext1);
        vertext2.neighbors.add(vertext3);

        //adding vertex3 neighbors
        vertext3.neighbors.add(vertext2);
        vertext3.neighbors.add(vertext4);

        //adding vertex4 neighbors
        vertext4.neighbors.add(vertext1);
        vertext4.neighbors.add(vertext3);

        cloneGraphDFS(vertext1);
    }

}
