package leetcode_questions.graph;

import java.util.*;

public class _103_Clone_Graph {
    private static class Node {
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

    public static Node cloneGraph(Node node) {
        if (node == null) return new Node();
        Map<Node, Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        int counter = 1;
        queue.add(node);
        visited.add(node);
        map.put(node, new Node(counter++));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (node.neighbors == null) continue;
            for (Node next : node.neighbors) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                    if (!map.containsKey(next)) {
                        map.put(next, new Node(counter++));
                    }
                    map.get(cur).neighbors.add(map.get(next));
                    map.get(next).neighbors.add(map.get(cur));
                }
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        cloneGraph(new Node());
    }

}
