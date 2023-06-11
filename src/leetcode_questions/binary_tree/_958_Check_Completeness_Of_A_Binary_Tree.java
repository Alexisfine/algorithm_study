package leetcode_questions.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _958_Check_Completeness_Of_A_Binary_Tree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean hasEnded = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right != null) return false;
                if (hasEnded && (node.left != null || node.right != null)) return false;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (node.left == null || node.right == null) hasEnded = true;
            }
        }
        return true;
    }


}
