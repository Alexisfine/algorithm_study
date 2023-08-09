package leetcode_questions.binary_tree;

import java.util.*;

public class _2385_Amount_Of_Time_For_Binary_Tree_To_Be_Infected {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(root.val, new ArrayList<>());
        createMap(root, root.left, map);
        createMap(root, root.right, map);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int nextNode : map.get(node)) {
                    if (!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        queue.offer(nextNode);
                    }
                }
            }
            time++;
        }
        return time;
    }

    private void createMap(TreeNode parent, TreeNode node, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        map.get(parent.val).add(node.val);
        map.put(node.val, new ArrayList<>());
        map.get(node.val).add(parent.val);
        createMap(node, node.left, map);
        createMap(node, node.right, map);
    }
}
