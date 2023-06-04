package leetcode_questions.graph.bfs;

import java.util.*;

public class _1129_Shortest_Path_With_Alternating_Colors {
    // Time: O(N + E)
    // Space: O(N + E)
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        HashMap<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int i = 0; i < redEdges.length; i++) {
            graph.putIfAbsent(redEdges[i][0], new ArrayList<>());
            graph.get(redEdges[i][0]).add(List.of(redEdges[i][0], redEdges[i][1], 0));
        }

        for (int i = 0; i < blueEdges.length; i++) {
            graph.putIfAbsent(blueEdges[i][0], new ArrayList<>());
            graph.get(blueEdges[i][0]).add(List.of(blueEdges[i][0], blueEdges[i][1], 1));
        }

        HashSet<List<Integer>> visited = new HashSet<>();
        // three indices represents current node, length, prevNode color
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0, 0, 2));

        while (!queue.isEmpty()) {
            List<Integer> node = queue.poll();
            int curNode = node.get(0);
            int length = node.get(1);
            int color = node.get(2);
            if (res[curNode] == -1) res[curNode] = length;
            if (graph.containsKey(curNode)) {
                for (List<Integer> next : graph.get(curNode)) {
                    if (next.get(2) == color || visited.contains(List.of(next.get(1), next.get(2)))) {
                        continue;
                    }
                    queue.add(List.of(next.get(1), length + 1, next.get(2)));
                    visited.add(List.of(next.get(1), next.get(2)));
                }
            }
        }

        return res;
    }
}
