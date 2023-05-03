package leetcode_questions.graph;

import java.util.*;

public class _886_Possible_Bipartition {
    // Solution: Change it into a graph coloring problem and use BFS/DFS
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < color.length; i++) {
            graph.add(new ArrayList<>());
        }
        // create a graph
        for (int i = 0; i < dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        // there may be separate forests
        for (int i = 1; i < color.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int neighbor : graph.get(cur)) {
                        if (color[neighbor] == 0) {
                            color[neighbor] = color[cur] == 1 ? -1 : 1;
                            queue.offer(neighbor);
                        } else {
                            if (color[neighbor] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
