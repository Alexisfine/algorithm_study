package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _1514_Path_With_Maximum_Probability {
    // n number of nodes, m number of edges
    // Time: O(MlogN + M)
    // Space: O(N + M)
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (n == 1) return 1.0;
        double[] successRate = new double[n];
        for (int i = 0; i < n; i++) successRate[i] = Integer.MAX_VALUE;
        successRate[start] = 1.0;

        Map<Integer, List<List<Double>>> graph = new HashMap<>(n);
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(List.of((double) edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(List.of((double) edges[i][0], succProb[i]));
        }

        // {index, success rate}
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        Set<Integer> visited = new HashSet<>(n);
        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {
            double[] pos = pq.poll();
            int index = (int) pos[0];
            double fail = pos[1];
            if (visited.contains(index)) continue;
            visited.add(index);
            successRate[index] = fail;
            if (graph.containsKey(index)) {
                for (List<Double> next : graph.get(index)) {
                    double nextIndex = next.get(0);
                    double nextFail = next.get(1);
                    if (!visited.contains((int) nextIndex)) {
                        pq.offer(new double[]{nextIndex, fail * nextFail});
                    }
                }
            }

        }
        return successRate[end] == Integer.MAX_VALUE ? 0.0 : successRate[end];
    }


}
