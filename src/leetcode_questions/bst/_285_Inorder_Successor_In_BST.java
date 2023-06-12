package leetcode_questions.bst;

import java.util.Stack;

public class _285_Inorder_Successor_In_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean isNext = false;
        if (root == null || p == null) return null;
        TreeNode curNode = root;
        TreeNode prevNode = null;
        while (curNode.val != p.val) {
            if (curNode.val < p.val) {
                prevNode = curNode;
                curNode = curNode.right;
            } else if (curNode.val > p.val) {
                prevNode = curNode;
                curNode = curNode.left;
            }
        }
        if (curNode.right != null) {
            return mostLeft(curNode.right);
        } else {
            return mostLeft(prevNode.right);
        }
    }

    private TreeNode mostLeft(TreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
