package leetcode_questions.dynamic_programming.trees;


import java.util.ArrayList;
import java.util.List;

public class _95_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        return process(1, n);
    }

    private List<TreeNode> process(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = process(start, i - 1);
            List<TreeNode> rightList = process(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
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
