package leetcode_questions.binary_tree;

public class _250_Univalue_Subtrees {
    private class Info {
        int subtrees;
        boolean sameVal;
        int val;
        public Info(int subtrees, boolean sameVal, int val) {
            this.subtrees = subtrees;
            this.sameVal = sameVal;
            this.val = val;
        }
    }
    // Time: O(N)
    // Space: O(N)
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        Info res = process(root);
        return res.subtrees;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, true, Integer.MAX_VALUE);
        }

        Info left = process(node.left);
        Info right = process(node.right);

        int val = node.val;
        boolean sameVal = true;
        if (left.val != Integer.MAX_VALUE && left.val != node.val) {
            sameVal = false;
        }

        if (right.val != Integer.MAX_VALUE && right.val != node.val) {
            sameVal = false;
        }
        int subtrees = left.subtrees + right.subtrees;
        if (sameVal && left.sameVal && right.sameVal) subtrees++;
        return new Info(subtrees, sameVal, val);
    }
}
