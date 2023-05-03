package leetcode_questions.binary_tree;

import binary_tree.Morris;
import com.sun.source.tree.Tree;

public class _98_Validate_Binary_Search_Tree {
    // Time O(n)
    // Space O(1)
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode cur = root;
        TreeNode mostRight = null;
        long value = Long.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) mostRight = mostRight.right;
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            if (value < cur.val) {
                value = cur.val;
            } else return false;
            cur = cur.right;
        }
        return true;
    }
}
