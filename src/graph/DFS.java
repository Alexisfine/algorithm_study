package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node) {
        if (node == null) return;
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        visited.add(node);
        stack.push(node);
        System.out.println(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node n: cur.nexts) {
                if (!visited.contains(n)) {
                    stack.push(cur);
                    stack.push(n);
                    visited.add(n);
                    System.out.println(n);
                    break;
                }
            }
        }
    }
}
