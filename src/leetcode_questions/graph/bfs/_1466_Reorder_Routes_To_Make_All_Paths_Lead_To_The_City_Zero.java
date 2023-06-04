package leetcode_questions.graph.bfs;

import java.util.*;

public class _1466_Reorder_Routes_To_Make_All_Paths_Lead_To_The_City_Zero {
    // Time: O(N)
    // Space: O(N)
    public int minReorder(int n, int[][] connections) {
        int total = 0;
        HashMap<Integer, List<int[]>> graph = new HashMap<>(n);
        for (int i = 0; i < connections.length; i++) {
            graph.putIfAbsent(connections[i][0], new ArrayList<>());
            graph.putIfAbsent(connections[i][1], new ArrayList<>());
            graph.get(connections[i][0]).add(new int[]{connections[i][1], 1});
            graph.get(connections[i][1]).add(new int[]{connections[i][0], 0});
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curNode = node[0];
            int isOutDegree = node[1];
            total += isOutDegree;
            if (graph.containsKey(curNode)) {
                for (int[] next : graph.get(curNode)) {
                    if (!visited.contains(next[0])) {
                        visited.add(next[0]);
                        queue.add(next);
                    }
                }
            }
        }
        return total;
    }
}
