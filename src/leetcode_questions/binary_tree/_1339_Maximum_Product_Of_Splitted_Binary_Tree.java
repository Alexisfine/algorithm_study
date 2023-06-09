package leetcode_questions.binary_tree;

public class _1339_Maximum_Product_Of_Splitted_Binary_Tree {
    long sum;
    long modulo = (long) Math.pow(10, 9) + 7;
    private class Info {
        long sum;
        long maxProductSoFar;
        public Info(long sum, long maxProductSoFar) {
            this.sum = sum;
            this.maxProductSoFar = maxProductSoFar;
        }
    }
    // Time: O(N)
    // Space: O(N)
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        this.sum = getSum(root);
        Info info = process(root);
        return (int) (info.maxProductSoFar % modulo);
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        long curSum = leftInfo.sum + rightInfo.sum + node.val;
        long cutLeft = (sum - leftInfo.sum) * leftInfo.sum;
        long cutRight = (sum - rightInfo.sum) * rightInfo.sum;
        long maxProductSoFar = Math.max(leftInfo.maxProductSoFar,
                Math.max(rightInfo.maxProductSoFar, Math.max(cutLeft, cutRight)));
        return new Info(curSum, maxProductSoFar);
    }

    private long getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }


}
