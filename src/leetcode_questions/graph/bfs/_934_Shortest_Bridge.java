package leetcode_questions.graph.bfs;

import java.util.*;

public class _934_Shortest_Bridge {
    // Time: O(N^2)
    // Space: O(N^2)
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[][] grid;
    private int N;
    private HashSet<List<Integer>> visited = new HashSet<>();
    private Queue<List<Integer>> queue = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        this.N = grid.length;

        boolean findOne = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    findOne = true;
                    break;
                }
            }
            if (findOne) break;
        }

        int flips = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> position = queue.poll();
                if (flips > 0 && grid[position.get(0)][position.get(1)] == 1) return flips - 1;
                for (int[] next : directions) {
                    if (!isValid(position.get(0) + next[0], position.get(1) + next[1])) continue;
                    List<Integer> future = List.of(position.get(0) + next[0], position.get(1) + next[1]);
                    if (visited.contains(future)) continue;
                    queue.add(future);
                    visited.add(future);
                }
            }
            flips++;
        }
        return 0;
    }

    private void dfs(int i, int j) {
        List<Integer> position = List.of(i, j);
        if (!isValid(i, j) || visited.contains(position) || grid[i][j] != 1) return;
        visited.add(position);
        queue.add(position);
        for (int[] next : directions) {
            dfs(i + next[0], j + next[1]);
        }
    }

    private boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < N && j < N);
    }



}
