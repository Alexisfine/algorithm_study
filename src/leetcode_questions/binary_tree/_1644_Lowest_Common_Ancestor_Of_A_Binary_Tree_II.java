package leetcode_questions.binary_tree;

public class _1644_Lowest_Common_Ancestor_Of_A_Binary_Tree_II {
    private class Info {
        boolean hasP;
        boolean hasQ;
        TreeNode lca;
        public Info(boolean hasP, boolean hasQ, TreeNode lca) {
            this.hasP = hasP;
            this.hasQ = hasQ;
            this.lca = lca;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (p == q) return p;
        Info info = process(root, p, q);
        return info.lca;
    }

    private Info process(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new Info(false, false, null);
        }

        Info leftInfo = process(node.left, p, q);
        Info rightInfo = process(node.right, p, q);

        if (leftInfo.lca != null) {
            return leftInfo;
        }
        if (rightInfo.lca != null) {
            return rightInfo;
        }

        boolean hasP = leftInfo.hasP || rightInfo.hasP || p == node;
        boolean hasQ = leftInfo.hasQ || rightInfo.hasQ || q == node;

        if (hasQ && hasP) {
            return new Info(hasP, hasQ, node);
        }
        return new Info(hasP, hasQ, null);
    }
}
