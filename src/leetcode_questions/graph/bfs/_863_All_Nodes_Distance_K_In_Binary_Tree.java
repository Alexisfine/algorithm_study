package leetcode_questions.graph.bfs;

import java.util.*;

public class _863_All_Nodes_Distance_K_In_Binary_Tree {
    // Time: O(N)
    // Space: O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null) return res;
        if (k == 0) return List.of(target.val);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        dfs(null, root, graph);

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(target.val);
        visited.add(target.val);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (steps == k) {
                    res.add(cur);
                } else if (graph.containsKey(cur)) {
                    for (int next : graph.get(cur)) {
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            if (steps == k) break;
            steps++;
        }
        return res;
    }

    private void dfs(TreeNode prevNode, TreeNode curNode, HashMap<Integer, List<Integer>> graph) {
        if (curNode == null) return;
        if (prevNode != null) {
            graph.putIfAbsent(prevNode.val, new ArrayList<>());
            graph.putIfAbsent(curNode.val, new ArrayList<>());
            graph.get(prevNode.val).add(curNode.val);
            graph.get(curNode.val).add(prevNode.val);
        }
        dfs(curNode, curNode.left, graph);
        dfs(curNode, curNode.right, graph);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
