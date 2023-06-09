package leetcode_questions.binary_tree;

public class _814_Binary_Tree_Pruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        return process(root);
    }

    private TreeNode process(TreeNode node) {
        if (node == null) return null;
        node.left = process(node.left);
        node.right = process(node.right);
        if (node.left == null && node.right == null && node.val == 0) return null;
        return node;
    }
}
