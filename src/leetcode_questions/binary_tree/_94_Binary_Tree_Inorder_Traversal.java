package leetcode_questions.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_Binary_Tree_Inorder_Traversal {

    // iterative approach
    // O(n) time
    // O(h) space
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
                list.add(node.val);
            }
        }
        return list;
    }

    // morris traversal
    // O(n) time
    // O(1) space
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
