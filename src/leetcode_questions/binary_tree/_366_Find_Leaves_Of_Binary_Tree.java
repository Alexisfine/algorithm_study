package leetcode_questions.binary_tree;

import java.util.*;

public class _366_Find_Leaves_Of_Binary_Tree {
    // Time: O(N)
    // Space: O(N)
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> leaveNodes = new LinkedHashMap<>();
        dfs(leaveNodes, root);
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : leaveNodes.entrySet()) {
            list.add(entry.getValue());
        }
        return list;

    }

    private int dfs(Map<Integer, List<Integer>> leaveNodes, TreeNode node) {
        if (node.left == null && node.right == null) {
            leaveNodes.putIfAbsent(0, new ArrayList<>());
            leaveNodes.get(0).add(node.val);
            return 0;
        }

        int leftLevel = node.left == null ? 0 : dfs(leaveNodes, node.left) + 1;
        int rightLevel = node.right == null ? 0 : dfs(leaveNodes, node.right) + 1;
        int currentLevel = Math.max(leftLevel, rightLevel);
        leaveNodes.putIfAbsent(currentLevel, new ArrayList<>());
        leaveNodes.get(currentLevel).add(node.val);
        return currentLevel;
    }
}
