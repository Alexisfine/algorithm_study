package leetcode_questions.binary_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1110_Delete_Nodes_And_Return_Forest {
    Set<Integer> deleteSet;
    List<TreeNode> res;

    // Time: O(N + D)
    // Space: O(N + D)
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        this.deleteSet = new HashSet<>();
        this.res = new ArrayList<>();
        for (int i = 0; i < to_delete.length; i++) {
            deleteSet.add(to_delete[i]);
        }
        dfs(root, true);
        return res;
    }

    private void dfs(TreeNode node, boolean isRoot) {
        if (node == null) return;
        if (deleteSet.contains(node.val)) {
            dfs(node.left, true);
            dfs(node.right, true);
        } else {
            if (node.left != null) {
                if (deleteSet.contains(node.left.val)) {
                    dfs(node.left, true);
                    node.left = null;
                } else {
                    dfs(node.left, false);
                }
            }

            if (node.right != null) {
                if (deleteSet.contains(node.right.val)) {
                    dfs(node.right, true);
                    node.right = null;
                } else {
                    dfs(node.right, false);
                }
            }

            if (isRoot) {
                res.add(node);
            }
        }
    }
}
