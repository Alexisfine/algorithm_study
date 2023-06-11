package leetcode_questions.binary_tree;

import java.util.*;

public class _2458_Height_Of_Binary_Tree_After_Subtree_Removal_Queries {
    Map<Integer, PriorityQueue<Integer>> levelNodeMap;
    Map<Integer, Integer> nodeLevelMap;
    Map<Integer, Integer> nodeDepthMap;
    Map<Integer, Integer> cache;

    // N: Number of nodes, Q: number of queries
    // Time: O(N + Q)
    // Space: O(N)
    public int[] treeQueries(TreeNode root, int[] queries) {
        this.levelNodeMap = new HashMap<>();
        this.nodeLevelMap = new HashMap<>();
        this.nodeDepthMap = new HashMap<>();
        this.cache = new HashMap<>();

        process(root, 0);

        int[] res = new int[queries.length];
        int counter = 0;
        for (int i : queries) {
            if (cache.containsKey(i)) {
                res[counter++] = cache.get(i);
                continue;
            }
            int level = nodeLevelMap.get(i);
            PriorityQueue<Integer> pq = levelNodeMap.get(level);
            if (pq.size() == 1) {
                res[counter++] = level - 1;
                cache.put(i, level - 1);
            } else if (pq.peek() == i) {
                int max = pq.poll();
                res[counter++] = nodeDepthMap.get(pq.peek());
                cache.put(i, nodeDepthMap.get(pq.peek()));
                pq.offer(max);
            } else {
                res[counter++] = nodeDepthMap.get(pq.peek());
                cache.put(i, nodeDepthMap.get(pq.peek()));
            }
        }
        return res;
    }

    private int process(TreeNode node, int level) {
        if (node == null) return -1;

        nodeLevelMap.put(node.val, level);
        int left = process(node.left, level + 1);
        int right = process(node.right, level + 1);
        int depth = Math.max(left, right) + 1;
        nodeDepthMap.put(node.val, level + depth);

        levelNodeMap.putIfAbsent(level, new PriorityQueue<>(2,
                (a, b) -> nodeDepthMap.get(b) - nodeDepthMap.get(a)));

        PriorityQueue<Integer> pq = levelNodeMap.get(level);
        if (pq.size() < 2) {
            pq.offer(node.val);
        } else {
            int max = pq.poll();
            int secondMax = pq.peek();
            if (nodeDepthMap.get(secondMax) < nodeDepthMap.get(node.val)) {
                pq.poll();
                pq.offer(node.val);
            }
            pq.offer(max);
        }
        return depth;
    }
}
