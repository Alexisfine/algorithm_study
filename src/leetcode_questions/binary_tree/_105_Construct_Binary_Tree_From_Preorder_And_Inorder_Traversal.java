package leetcode_questions.binary_tree;

import java.util.HashMap;
import java.util.Map;

public class _105_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {
    Map<Integer, Integer> inorderMap;
    int[] preorder;
    int[] inorder;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        this.inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return process(0, preorder.length - 1);

    }
    private TreeNode process(int lo, int hi) {
        if (lo > hi) return null;
        int curVal = preorder[index++];
        TreeNode node = new TreeNode(curVal);
        node.left = process(lo, inorderMap.get(curVal) - 1);
        node.right = process(inorderMap.get(curVal) + 1, hi);
        return node;
    }


}
