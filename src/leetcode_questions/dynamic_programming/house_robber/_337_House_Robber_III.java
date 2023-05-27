package leetcode_questions.dynamic_programming.house_robber;

public class _337_House_Robber_III {
    private static class Info {
        int includeNode;
        int notIncludeNode;
        public Info(int includeNode, int notIncludeNode) {
            this.includeNode = includeNode;
            this.notIncludeNode = notIncludeNode;
        }
    }

    // Time: O(N)
    // Space: O(N)
    public static int rob(TreeNode root) {
        if (root == null) return 0;
        Info res = process(root);
        return Math.max(res.includeNode, res.notIncludeNode);
    }

    private static Info process(TreeNode node) {
        if (node == null) return new Info(0, 0);
        Info left = process(node.left);
        Info right = process(node.right);
        int maxExcludeNode = Math.max(left.includeNode, left.notIncludeNode)
                + Math.max(right.includeNode, right.notIncludeNode);
        int maxIncludeNode = left.notIncludeNode + right.notIncludeNode + node.val;
        return new Info(maxIncludeNode, maxExcludeNode);
    }

    public static class TreeNode {
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
