package leetcode_questions.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class _662_Maximum_Width_Of_Binary_Tree {
    public record Info(TreeNode node, int pos) {}
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 1;
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = 0;
            int max = 0;
            for (int i = 0; i < size; i++) {
                Info curInfo = queue.poll();
                if (i == 0) min = curInfo.pos;
                if (i == size - 1) max = curInfo.pos;
                if (curInfo.node.left != null) {
                    queue.offer(new Info(curInfo.node.left, curInfo.pos * 2));
                }
                if (curInfo.node.right != null) {
                    queue.offer(new Info(curInfo.node.right, curInfo.pos * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
    }
}
