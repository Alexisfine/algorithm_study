package leetcode_questions.binary_tree;

public class _543_Diameter_Of_Binary_Tree {
    public static class Info {
        int maxDistance;
        int height;
        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static int diameterOfBinaryTree(TreeNode node) {
        return process(node).maxDistance - 1;
    }

    private static Info process(TreeNode node) {
        if (node == null) return new Info(0, 0);

        Info left = process(node.left);
        Info right = process(node.right);
        int d1 = left.maxDistance;
        int d2 = right.maxDistance;
        int d3 = left.height + right.height + 1;
        int maxDistance = Math.max(d3, Math.max(d1, d2));
        int height = Math.max(left.height, right.height) + 1;
        return new Info(maxDistance, height);
    }
}
