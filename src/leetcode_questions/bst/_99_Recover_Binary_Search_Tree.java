package leetcode_questions.bst;


import java.util.Stack;

public class _99_Recover_Binary_Search_Tree {
    // Time: O(N)
    // Space: O(N)
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        TreeNode x = null, y = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (prevNode != null && prevNode.val >= node.val) {
                    y = node;
                    if (x != null) break;
                    else x = prevNode;
                }
                prevNode = node;
                root = node.right;
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
