package leetcode_questions.binary_search;

public class _270_Closest_Binary_Search_Tree_Value {
    public int closestValue(TreeNode root, double target) {
        TreeNode curNode = root;
        int currentBest = curNode.val;
        while (curNode != null) {
            if (curNode.val == target) return curNode.val;

            double distanceA = Math.abs(currentBest - target);
            double distanceB = Math.abs(curNode.val - target);
            if (distanceA == distanceB) {
                currentBest = currentBest < curNode.val ? currentBest : curNode.val;
            } else if (distanceB < distanceA) {
                currentBest = curNode.val;
            }

            if (curNode.val > target) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return currentBest;
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
