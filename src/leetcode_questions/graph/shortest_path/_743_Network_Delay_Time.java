package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _743_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            graph.putIfAbsent(times[i][0], new ArrayList<>());
            graph.get(times[i][0]).add(times[i]);
        }

        int maxTime = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[2], y[2]));
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new int[]{k, k, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (visited.contains(node[1])) continue;
            visited.add(node[1]);
            maxTime = Math.max(maxTime, node[2]);
            if (graph.containsKey(node[1])) {
                for (int[] edge : graph.get(node[1])) {
                    if (!visited.contains(edge[1])) {
                        pq.add(new int[]{edge[0], edge[1], edge[2] + node[2]});
                    }
                }
            }
            if (visited.size() == n) break;
        }
        return visited.size() == n ? maxTime : -1;
    }
}
