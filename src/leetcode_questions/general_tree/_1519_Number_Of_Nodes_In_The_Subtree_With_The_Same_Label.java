package leetcode_questions.general_tree;

import java.util.*;

public class _1519_Number_Of_Nodes_In_The_Subtree_With_The_Same_Label {

    Map<Integer, List<Integer>> graph;
    String labels;
    int[] res;
    int[] rollingCount;

    // Time: O(26*N) = O(N)
    // Space: O(26*N) = O(N)
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.graph = new HashMap<>();
        this.labels = labels;
        this.res = new int[n];
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(0, visited);
        return res;
    }

    private int[] dfs(int node, Set<Integer> visited) {
        int[] arr = new int[26];
        char label = labels.charAt(node);
        arr[label - 'a'] = 1;

        if (graph.containsKey(node)) {
            for (int nextNode : graph.get(node)) {
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    int[] childData = dfs(nextNode, visited);
                    for (int i = 0; i < 26; i++) {
                        arr[i] += childData[i];
                    }
                }
            }
        }
        res[node] = arr[label - 'a'];
        return arr;
    }

    // Time: O(N) < O(26N)
    // Space: O(N) < O(26N)
    public int[] countSubTrees2(int n, int[][] edges, String labels) {
        this.graph = new HashMap<>();
        this.labels = labels;
        this.res = new int[n];
        this.rollingCount = new int[26];
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs2(0, visited);
        return res;
    }

    private void dfs2(int node, Set<Integer> visited) {
        char label = labels.charAt(node);
        int prevNodeCount = rollingCount[label - 'a'];

        if (graph.containsKey(node)) {
            for (int nextNode : graph.get(node)) {
                if (!visited.contains(nextNode)) {
                    visited.add(nextNode);
                    dfs2(nextNode, visited);
                }
            }
        }
        res[node] = rollingCount[label - 'a'] - prevNodeCount + 1;
        rollingCount[label - 'a']++;
    }
}
