package leetcode_questions.graph.dfs;

import java.util.*;

public class _103_Clone_Graph {
    // Time: O(N + M)
    // Space: O(N)
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> oldToNew = new HashMap<>();
        return process(oldToNew, node);
    }

    private Node process(HashMap<Node,Node> oldToNew, Node oldNode) {
        if (oldToNew.containsKey(oldNode)) return oldToNew.get(oldNode);
        Node newNode = new Node(oldNode.val);
        oldToNew.put(oldNode, newNode);
        for (Node neighbor : oldNode.neighbors) {
            Node newNeighbor = process(oldToNew, neighbor);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
}
