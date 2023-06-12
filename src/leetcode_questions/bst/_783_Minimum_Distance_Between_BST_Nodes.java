package leetcode_questions.bst;

import java.util.Stack;

public class _783_Minimum_Distance_Between_BST_Nodes {
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        int difference = Integer.MAX_VALUE;
        int prevNodeVal = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
                if (prevNodeVal == Integer.MAX_VALUE) {
                    prevNodeVal = node.val;
                } else {
                    difference = Math.min(node.val - prevNodeVal, difference);
                }
            }
        }
        return difference;
    }

}
