package leetcode_questions.graph.graph_theory;

import java.util.*;

public class _785_Is_Graph_Bipartite {
    // Time: O(N + E)
    // Space: O(N)
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] color = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                HashSet<Integer> visited = new HashSet<>();
                queue.add(i);
                visited.add(i);
                boolean isRed = true;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int cur = queue.poll();
                        color[cur] = isRed ? 1 : 2;
                        for (int next : graph[cur]) {
                            if (visited.contains(next)) {
                                if (color[next] == (isRed ? 1 : 2)) return false;
                            } else {
                                queue.add(next);
                                visited.add(next);
                            }
                        }
                    }
                    isRed = !isRed;
                }
            }
        }
        return true;
    }
}
