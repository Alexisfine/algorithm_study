package leetcode_questions.binary_tree;

import java.util.*;

public class _863_All_Nodes_Distance_K_In_Binary_Tree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || target == null) return res;

        // initialize graph
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        graph.put(root, new ArrayList<>());
        if (root.left != null) {
            graph.get(root).add(root.left);
            dfs(root, root.left, graph);
        }
        if (root.right != null) {
            graph.get(root).add(root.right);
            dfs(root, root.right, graph);
        }

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (step == k) {
                    res.add(curNode.val);
                    continue;
                }

                if (graph.containsKey(curNode)) {
                    for (TreeNode nextNode : graph.get(curNode)) {
                        if (!visited.contains(nextNode)) {
                            queue.offer(nextNode);
                            visited.add(nextNode);
                        }
                    }
                }
            }
            step++;
        }
        return res;
    }

    private void dfs(TreeNode prevNode, TreeNode curNode, Map<TreeNode, List<TreeNode>> graph) {
        if (curNode == null) return;
        graph.put(curNode, new ArrayList<>());
        graph.get(curNode).add(prevNode);

        if (curNode.left != null) {
            graph.get(curNode).add(curNode.left);
            dfs(curNode, curNode.left, graph);
        }

        if (curNode.right != null) {
            graph.get(curNode).add(curNode.right);
            dfs(curNode, curNode.right, graph);
        }
    }
}
