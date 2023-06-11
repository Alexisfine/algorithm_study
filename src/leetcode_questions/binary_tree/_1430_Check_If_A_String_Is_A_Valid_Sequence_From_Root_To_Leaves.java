package leetcode_questions.binary_tree;

public class _1430_Check_If_A_String_Is_A_Valid_Sequence_From_Root_To_Leaves {
    int[] arr;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        this.arr = arr;
        return process(root, 0);
    }

    private boolean process(TreeNode node, int index) {
        if (node == null || node.val != arr[index]) return false;
        if (index == arr.length - 1) {
            return node.left == null && node.right == null;
        }
        boolean left = process(node.left, index + 1);
        boolean right = process(node.right, index + 1);
        return left || right;
    }
}
