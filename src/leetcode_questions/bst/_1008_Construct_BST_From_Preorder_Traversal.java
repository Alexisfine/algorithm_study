package leetcode_questions.bst;

import java.util.Stack;

public class _1008_Construct_BST_From_Preorder_Traversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return process(preorder, 0, preorder.length - 1);
    }

    private TreeNode process(int[] preorder, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo;
        int cutoff = lo;
        while (cutoff < preorder.length && preorder[cutoff] <= preorder[mid]) {
            cutoff++;
        }
        TreeNode node = new TreeNode(preorder[mid++]);
        // construct left subtree
        node.left = process(preorder, mid, cutoff - 1);
        node.right = process(preorder, cutoff, hi);
        return node;
    }
}
