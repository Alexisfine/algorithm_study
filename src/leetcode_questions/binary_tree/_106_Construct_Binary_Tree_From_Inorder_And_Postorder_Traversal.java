package leetcode_questions.binary_tree;

import leetcode_questions.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal {
    Map<Integer, Integer> inorderIndexMap;
    int[] inorder;
    int[] postorder;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        this.inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        this.index = inorder.length - 1;
        return process(0, inorder.length - 1);


    }
    private TreeNode process(int lo, int hi) {
        if (lo > hi) return null;
        int curVal = postorder[index--];
        TreeNode node = new TreeNode(curVal);
        node.right = process(inorderIndexMap.get(curVal) + 1, hi);
        node.left = process(lo, inorderIndexMap.get(curVal) - 1);
        return node;
    }
}
