package leetcode_questions.general_tree.sum_of_distances_in_tree;

import java.util.*;

public class _834_Sum_Of_Distances_In_Tree_I {

    // Approach 1
    // Time: O(N) TLE
    // Space: O(N)
    private record Pair(int prevNode, int curNode) {}
    private class Info {
        int nodes;
        int distance;
        public Info(int nodes, int distance) {
            this.nodes = nodes;
            this.distance = distance;
        }
    }
    Map<Integer, List<Integer>> graph;
    Map<Pair, Info> distanceMap;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] res = new int[n];

        this.graph = new HashMap<>();
        this.distanceMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            res[i] = dfs(-1, i).distance;
        }
        return res;
    }

    private Info dfs(int prevNode, int curNode) {
        Pair pair = new Pair(prevNode, curNode);
        int distance = 0;
        int nodes = 0;
        if (distanceMap.containsKey(pair)) return distanceMap.get(pair);

        if (graph.containsKey(curNode)) {
            for (int nextNode : graph.get(curNode)) {
                if (prevNode == nextNode) continue;
                Info data = dfs(curNode, nextNode);
                nodes += data.nodes;
                distance += data.distance;
                distance += data.nodes;
            }
        }
        nodes++;
        Info res = new Info(nodes, distance);
        distanceMap.put(pair, res);
        return res;
    }
}
