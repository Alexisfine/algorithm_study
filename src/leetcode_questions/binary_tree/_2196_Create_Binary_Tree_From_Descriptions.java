package leetcode_questions.binary_tree;

import java.util.*;

public class _2196_Create_Binary_Tree_From_Descriptions {
    Map<Integer, List<int[]>> treeMap;
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions == null || descriptions.length == 0) return null;

        this.treeMap = new HashMap<>();
        Set<Integer> notRoot = new HashSet<>();
        for (int i = 0; i < descriptions.length; i++) {
            treeMap.putIfAbsent(descriptions[i][0], new ArrayList<>());
            treeMap.get(descriptions[i][0]).add(descriptions[i]);
            notRoot.add(descriptions[i][1]);
        }
        int root = 0;
        for (int i = 0; i < descriptions.length; i++) {
            if (!notRoot.contains(descriptions[i][0])) {
                root = descriptions[i][0];
                break;
            }
        }
        return process(root);
    }

    private TreeNode process(int val) {
        TreeNode node = new TreeNode(val);
        if (!treeMap.containsKey(val)) {
            return node;
        }

        for (int[] arr : treeMap.get(val)) {
            if (arr[2] == 1) {
                node.left = process(arr[1]);
            } else {
                node.right = process(arr[1]);
            }
        }
        return node;
    }
}
