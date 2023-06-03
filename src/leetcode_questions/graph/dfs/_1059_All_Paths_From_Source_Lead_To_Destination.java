package leetcode_questions.graph.dfs;

import java.util.*;

public class _1059_All_Paths_From_Source_Lead_To_Destination {
    // TLE
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new LinkedList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        return process(source, destination, graph, new HashSet<>());
    }

    private boolean process(int current, int destination, Map<Integer,
            List<Integer>> graph, Set<Integer> visited) {
        if (!graph.containsKey(current) && current == destination) return true;
        if (!graph.containsKey(current) || visited.contains(current)) return false;

        visited.add(current);
        for (int next : graph.get(current)) {
            if (!process(next, destination, graph, visited)) return false;
        }
        visited.remove(current);
        return true;
    }

}
