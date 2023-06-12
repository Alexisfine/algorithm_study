package leetcode_questions.bst;

public class _98_Validate_Binary_Search_Tree {
    private class Info {
        int max;
        int min;
        boolean isBST;
        public Info(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    private Info process(TreeNode node) {
        if (node == null) return null;
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int min = node.val;
        int max = node.val;

        if (leftInfo != null) {
            min = Math.min(leftInfo.min, min);
            max = Math.min(leftInfo.max, max);
        }

        if (rightInfo != null) {
            min = Math.min(rightInfo.min, min);
            max = Math.min(rightInfo.max, max);
        }

        boolean isBST = true;
        if (leftInfo != null && (!leftInfo.isBST || leftInfo.max >= node.val)) isBST = false;
        if (rightInfo != null && (!rightInfo.isBST || rightInfo.min <= node.val)) isBST = false;
        return new Info(min, max, isBST);
    }
}
