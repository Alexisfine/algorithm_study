package leetcode_questions.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _802_Find_Eventual_Safe_States {
    // Time: O(N)
    // Space: O(N + E)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            if (graph[i].length == 0) {
                dp[i] = 1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            process(graph, dp, set, i);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (dp[i] == 1) res.add(i);
        }
        return res;
    }

    private int process(int[][] graph, int[] dp, Set<Integer> visited, int current) {
        if (dp[current] != 0) return dp[current];
        visited.add(current);
        for (int next : graph[current]) {
            if (visited.contains(next)) {
                dp[current] = -1;
                return dp[current];
            }
            if (process(graph, dp, visited, next) == -1) {
                dp[current] = -1;
                return dp[current];
            }
        }
        dp[current] = 1;
        visited.remove(current);
        return dp[current];
    }
}
