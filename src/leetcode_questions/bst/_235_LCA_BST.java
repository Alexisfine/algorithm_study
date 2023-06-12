package leetcode_questions.bst;

public class _235_LCA_BST {
    // Time: O(N)
    // Space: O(N) Can optimized to O(1) using iterative approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val < root.val && q.val > root.val) {
            return root;
        }
        if (q.val < root.val && p.val > root.val) {
            return root;
        }
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
