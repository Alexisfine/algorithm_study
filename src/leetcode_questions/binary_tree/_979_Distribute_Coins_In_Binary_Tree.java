package leetcode_questions.binary_tree;

public class _979_Distribute_Coins_In_Binary_Tree {
    int moves;
    // Time: O(N)
    // Space: O(N)
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;
        this.moves = 0;
        process(root);
        return moves;
    }

    private int process(TreeNode node) {
        if (node == null) return 0;
        int left = process(node.left);
        int right = process(node.right);
        moves += Math.abs(left);
        moves += Math.abs(right);
        return node.val + left + right - 1;
    }
}
