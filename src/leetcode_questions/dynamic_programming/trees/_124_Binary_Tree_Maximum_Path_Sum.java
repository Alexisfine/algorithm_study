package leetcode_questions.dynamic_programming.trees;

public class _124_Binary_Tree_Maximum_Path_Sum {
    boolean allNegative = true;
    int maxNegative = Integer.MIN_VALUE;
    private static class Info {
        int maxOneSide;
        int maxWithinNode;
        public Info(int maxOneSide, int maxWithinNode) {
            this.maxOneSide = maxOneSide;
            this.maxWithinNode = maxWithinNode;
        }
    }
    // Time: O(N)
    // Space: O(N)
    public int maxPathSum(TreeNode root) {
        Info info = process(root);
        if (allNegative) return maxNegative;
        return Math.max(info.maxWithinNode, Math.max(info.maxOneSide, 0));
    }

    private Info process(TreeNode node) {
        // base case
        if (node == null) {
            return new Info(0, 0);
        }
        if (node.val >= 0) allNegative = false;
        if (allNegative) maxNegative = Math.max(maxNegative, node.val);
        Info left = process(node.left);
        Info right = process(node.right);
        int maxOneSide = Math.max(Math.max(left.maxOneSide, right.maxOneSide) + node.val, node.val);
        int maxWithinNode = node.val;
        if (left.maxOneSide > 0) maxWithinNode += left.maxOneSide;
        if (right.maxOneSide > 0) maxWithinNode += right.maxOneSide;;
        maxWithinNode = Math.max(maxWithinNode, Math.max(left.maxWithinNode, right.maxWithinNode));
        return new Info(maxOneSide, maxWithinNode);
    }




    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
