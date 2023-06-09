package leetcode_questions.binary_tree;

public class _222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) + countNodes(root.right);
        } else {
            return countNodes(root.left) + (int)Math.pow(2, rightHeight);
        }
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + height(node.left);
    }
}
