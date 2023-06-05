package leetcode_questions.graph.graph_theory;

import java.util.HashMap;
import java.util.HashSet;

public class _997_Find_The_Town_Judge {
    // Time: O(E + N)
    // Space: O(N)
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        int[] graph = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            graph[trust[i][0]]--;
            graph[trust[i][1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (graph[i] == n - 1) return i;
        }
        return -1;
    }
}
