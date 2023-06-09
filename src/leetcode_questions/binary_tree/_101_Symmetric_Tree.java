package leetcode_questions.binary_tree;

public class _101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return process(left.left, right.right) && process(right.left, left.right);
    }
}
