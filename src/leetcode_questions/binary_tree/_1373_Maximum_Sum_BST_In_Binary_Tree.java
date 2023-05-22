package leetcode_questions.binary_tree;


public class _1373_Maximum_Sum_BST_In_Binary_Tree {
    private static class Info {
        int maxSum;
        boolean isBST;
        int min;
        int max;
        public Info(int maxSum, boolean isBST, int min, int max) {
            this.maxSum = maxSum;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        return process(root).maxSum;
    }

    private static Info process(TreeNode node) {
        if (node == null) return null;

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int min = node.val;
        int max = node.val;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        int maxBSTSize = 0;
        int maxSum = 0;
        boolean isBST = false;


        if (leftInfo != null) {
            maxSum = leftInfo.maxSum;
        }
        if (rightInfo != null && rightInfo.maxSum > maxSum) {
            maxSum = rightInfo.maxSum;
        }

        if ((leftInfo == null || leftInfo.isBST) && (rightInfo == null || rightInfo.isBST)) {
            if ((leftInfo == null || leftInfo.max < node.val) && (rightInfo == null || node.val < rightInfo.min)) {
                isBST = true;
                maxSum = node.val + (leftInfo == null ? 0 : leftInfo.maxSum)
                        + (rightInfo == null ? 0 : rightInfo.maxSum);

            }
        }
        return new Info(maxSum, isBST, min, max);
    }
}
