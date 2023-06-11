package leetcode_questions.binary_tree;

import java.net.Inet4Address;
import java.util.*;

public class _652_Find_Duplicate_Subtrees {
    Map<String, Integer> subtrees;
    List<TreeNode> res;
    // Time: O(N^2)
    // Space: O(N^2)
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.res = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        this.subtrees = new HashMap<>();
        process(root);
        return res;
    }
    private StringBuilder process(TreeNode node) {
        if (node == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('N');
            sb.append('_');
            return sb;
        }
        StringBuilder sb = new StringBuilder();

        sb.append(node.val);
        sb.append('_');
        StringBuilder left = process(node.left);
        sb.append(left);
        StringBuilder right = process(node.right);
        sb.append(right);

        String str = new String(sb);
        if (subtrees.containsKey(str)) {
            if (subtrees.get(str) < 2) {
                subtrees.put(str, 2);
                res.add(node);
            }
        } else {
            subtrees.put(str, 1);
        }
        return sb;
    }
}
