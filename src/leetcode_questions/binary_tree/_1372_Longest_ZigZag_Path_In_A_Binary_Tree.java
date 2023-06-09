package leetcode_questions.binary_tree;

public class _1372_Longest_ZigZag_Path_In_A_Binary_Tree {
    private class Info {
        int maxLeft;
        int maxRight;
        int currentBest;
        public Info(int maxLeft, int maxRight, int currentBest) {
            this.maxLeft = maxLeft;
            this.maxRight = maxRight;
            this.currentBest = currentBest;
        }
    }
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        Info info = process(root);
        return info.currentBest - 1;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0, 0);
        }

        Info left = process(node.left);
        Info right = process(node.right);
        int maxLeft = left.maxRight + 1;
        int maxRight = right.maxLeft + 1;
        int currentBest = Math.max(left.currentBest,
                Math.max(right.currentBest, Math.max(maxLeft, maxRight)));
        return new Info(maxLeft, maxRight, currentBest);
    }
}
