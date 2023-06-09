package leetcode_questions.binary_tree;

import java.util.*;

public class _314_Binary_Tree_Vertical_Order_Traversal {
    public record Pos(TreeNode node, int pos) {}

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(root, 0));

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            map.putIfAbsent(cur.pos, new ArrayList<>());
            map.get(cur.pos).add(cur.node.val);
            if (cur.node.left != null) {
                queue.offer(new Pos(cur.node.left, cur.pos - 1));
            }
            if (cur.node.right != null) {
                queue.offer(new Pos(cur.node.right, cur.pos + 1));
            }
        }


        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
