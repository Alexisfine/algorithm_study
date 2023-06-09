package leetcode_questions.binary_tree;

public class _1026_Maximum_Difference_Between_Node_And_Ancestor {
    private class Info {
        int max;
        int min;
        int currentBest;
        public Info(int max, int min, int currentBest) {
            this.max = max;
            this.min = min;
            this.currentBest = currentBest;
        }
    }
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        Info info = process(root);
        return info.currentBest;
    }

    private Info process(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Info(node.val, node.val, 0);
        }

        int max = node.val;
        int min = node.val;
        int currentBest = 0;

        if (node.left != null && node.right != null) {
            Info leftInfo = process(node.left);
            Info rightInfo = process(node.right);
            currentBest = Math.max(Math.abs(node.val - leftInfo.max), Math.abs(node.val - leftInfo.min));
            currentBest = Math.max(currentBest,
                    Math.max(Math.abs(node.val - rightInfo.max), Math.abs(node.val - rightInfo.min)));
            currentBest = Math.max(currentBest, Math.max(rightInfo.currentBest, leftInfo.currentBest));
            max = Math.max(max, Math.max(leftInfo.max, rightInfo.max));
            min = Math.min(min, Math.min(leftInfo.min, rightInfo.min));
        } else if (node.left != null) {
            Info leftInfo = process(node.left);
            currentBest = Math.max(Math.abs(node.val - leftInfo.max), Math.abs(node.val - leftInfo.min));
            currentBest = Math.max(currentBest, leftInfo.currentBest);
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
        } else if (node.right != null) {
            Info rightInfo = process(node.right);
            currentBest = Math.max(Math.abs(node.val - rightInfo.max), Math.abs(node.val - rightInfo.min));
            currentBest = Math.max(currentBest, rightInfo.currentBest);
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }
        return new Info(max, min, currentBest);
    }
}
