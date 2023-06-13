package leetcode_questions.general_tree;

import java.util.*;

public class _1443_Minimum_Time_To_Collect_All_Apples_In_A_Tree {
    private class Info {
        boolean hasApples;
        int totalDistance;
        public Info(boolean hasApples, int totalDistance) {
            this.hasApples = hasApples;
            this.totalDistance = totalDistance;
        }
    }
    Map<Integer, List<Integer>> graph;
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.graph = new HashMap<>();
        this.hasApple = hasApple;
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>(n);
        visited.add(0);
        Info info = dfs(0, visited);
        return info.totalDistance;
    }

    private Info dfs(int node, Set<Integer> visited) {
        boolean hasApples = hasApple.get(node);
        int totalDistance = 0;

        if (graph.containsKey(node)) {
            for (int nextNode : graph.get(node)) {
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    Info info = dfs(nextNode, visited);
                    if (info.hasApples) {
                        totalDistance += info.totalDistance + 2;
                        hasApples = true;
                    }
                }
            }
        }
        return new Info(hasApples, totalDistance);
    }
}
