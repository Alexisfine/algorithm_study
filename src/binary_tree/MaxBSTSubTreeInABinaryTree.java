package binary_tree;


public class MaxBSTSubTreeInABinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Info {
        MaxBSTSubTreeInABinaryTree.TreeNode maxBSTHead;
        boolean isBST;
        int min;
        int max;
        int maxBSTSize;
        public Info(MaxBSTSubTreeInABinaryTree.TreeNode maxBSTHead, boolean isBST, int min, int max, int maxBSTSize) {
            this.maxBSTHead = maxBSTHead;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.maxBSTSize = maxBSTSize;
        }
    }
    public static TreeNode maxSumBST(TreeNode root) {
        if (root == null) return null;
        return process(root).maxBSTHead;
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
        TreeNode maxBSTHead = null;
        boolean isBST = false;


        if (leftInfo != null) {
            maxBSTSize = leftInfo.maxBSTSize;
            maxBSTHead = leftInfo.maxBSTHead;
        }
        if (rightInfo != null && rightInfo.maxBSTSize > maxBSTSize) {
            maxBSTSize = rightInfo.maxBSTSize;
            maxBSTHead = rightInfo.maxBSTHead;
        }

        if ((leftInfo == null || leftInfo.isBST) && (rightInfo == null || rightInfo.isBST)) {
            if ((leftInfo == null || leftInfo.max < node.val) && (rightInfo == null || node.val < rightInfo.min)) {
                isBST = true;
                maxBSTHead = node;
                maxBSTSize = 1 + (leftInfo == null ? 0 : leftInfo.maxBSTSize)
                        + (rightInfo == null ? 0 : rightInfo.maxBSTSize);
            }
        }
        return new Info(maxBSTHead, isBST, min, max, maxBSTSize);
    }
}
