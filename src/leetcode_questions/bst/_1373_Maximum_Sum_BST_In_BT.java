package leetcode_questions.bst;

public class _1373_Maximum_Sum_BST_In_BT {
    private class Info {
        boolean isBST;
        int maxBSTSum;
        int currentSum;
        int min;
        int max;
        public Info(boolean isBST, int maxBSTSum, int currentSum, int min, int max) {
            this.isBST = isBST;
            this.maxBSTSum = maxBSTSum;
            this.currentSum = currentSum;
            this.min = min;
            this.max = max;
        }
    }
    // Time: O(N)
    // Space: O(N)
    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        int sum = process(root).maxBSTSum;
        return Math.max(sum, 0);
    }

    private Info process(TreeNode node) {
        if (node == null) return null;

        Info left = process(node.left);
        Info right = process(node.right);

        int min = node.val;
        int max = node.val;

        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }

        boolean isBST = true;
        int currentSum = 0;
        if (left != null && (!left.isBST || node.val <= left.max)) isBST = false;
        if (right != null && (!right.isBST || right.min <= node.val)) isBST = false;

        int maxBSTSum = 0;
        if (left != null) maxBSTSum = Math.max(maxBSTSum, left.maxBSTSum);
        if (right != null) maxBSTSum = Math.max(maxBSTSum, right.maxBSTSum);


        if (isBST) {
            currentSum = node.val;
            if (left != null) currentSum += left.currentSum;
            if (right != null) currentSum += right.currentSum;
            maxBSTSum = Math.max(maxBSTSum, currentSum);
        }

        return new Info(isBST, maxBSTSum, currentSum, min, max);
    }
}
