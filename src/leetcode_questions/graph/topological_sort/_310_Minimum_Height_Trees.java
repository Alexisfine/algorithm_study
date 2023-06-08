package leetcode_questions.graph.topological_sort;

import java.util.*;

public class _310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inMap = new int[n];

        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            inMap[edges[i][0]]++;
            inMap[edges[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inMap[i] == 1) {
                queue.offer(i);
            }
        }

        int rest = n;
        List<Integer> res = new ArrayList<>();
        while (rest > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                rest--;
                if (graph.containsKey(curNode)) {
                    for (int nextNode : graph.get(curNode)) {
                        inMap[nextNode]--;
                        if (inMap[nextNode] == 1) {
                            queue.offer(nextNode);
                        }
                    }
                }
            }
        }

        res.addAll(queue);
        return res;
    }
}
