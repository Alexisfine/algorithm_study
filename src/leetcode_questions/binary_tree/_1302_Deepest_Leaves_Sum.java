package leetcode_questions.binary_tree;

public class _1302_Deepest_Leaves_Sum {
    private class Info {
        int depth;
        int sum;
        public Info(int depth, int sum) {
            this.depth = depth;
            this.sum = sum;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Info info = process(root);
        return info.sum;
    }

    private Info process(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new Info(0, node.val);
        }

        int maxDepth = 0;
        int sum = 0;
        if (node.left != null) {
            Info leftInfo = process(node.left);
            maxDepth = leftInfo.depth + 1;
            sum = leftInfo.sum;
        }

        if (node.right != null) {
            Info rightInfo = process(node.right);
            if (maxDepth < rightInfo.depth + 1) {
                maxDepth = rightInfo.depth + 1;
                sum = rightInfo.sum;
            } else if (maxDepth == rightInfo.depth + 1) {
                sum += rightInfo.sum;;
            }
        }
        return new Info(maxDepth, sum);
    }
}
