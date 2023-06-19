package leetcode_questions.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _1161_Maximum_Level_Sum_Of_A_Binary_Tree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int curLevel = 1;
        int maxLevel = 0;
        int maxValue = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int curSize = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curSize += curNode.val;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            if (curSize > maxValue) {
                maxLevel = curLevel;
                maxValue = curSize;
            }
            curLevel++;
        }
        return maxLevel;
    }
}
