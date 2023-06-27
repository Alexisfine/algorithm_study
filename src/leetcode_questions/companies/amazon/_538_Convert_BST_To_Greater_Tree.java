package leetcode_questions.companies.amazon;

public class _538_Convert_BST_To_Greater_Tree {
    int currentTotal = 0;

    public TreeNode convertBST(TreeNode root) {
        process(root);
        return root;
    }

    private void process(TreeNode node) {
        if (node == null) return;
        process(node.right);
        currentTotal += node.val;
        node.val = currentTotal;
        process(node.left);
    }



    public class TreeNode {
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
