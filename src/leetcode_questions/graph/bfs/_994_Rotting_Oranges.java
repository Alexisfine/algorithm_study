package leetcode_questions.graph.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _994_Rotting_Oranges {
    // Time: O(M * N)
    // Space: O(M * N)
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int freshOranges = 0;
        int times = -1;
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) freshOranges++;
                else if (grid[i][j] == 2) queue.add(List.of(i, j));
            }
        }

        if (freshOranges == 0) return 0;

        while (!queue.isEmpty()) {
            times++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> position = queue.poll();
                int r = position.get(0);
                int c = position.get(1);
                if (r > 0 && grid[r - 1][c] == 1) {
                    queue.add(List.of(r - 1, c));
                    grid[r - 1][c] = 2;
                    freshOranges--;
                }

                if (r < M - 1 && grid[r + 1][c] == 1) {
                    queue.add(List.of(r + 1, c));
                    grid[r + 1][c] = 2;
                    freshOranges--;
                }

                if (c > 0 && grid[r][c - 1] == 1) {
                    queue.add(List.of(r, c - 1));
                    grid[r][c - 1] = 2;
                    freshOranges--;
                }

                if (c < N - 1 && grid[r][c + 1] == 1) {
                    queue.add(List.of(r, c + 1));
                    grid[r][c + 1] = 2;
                    freshOranges--;
                }
            }
        }

        return freshOranges == 0 ? times : -1;
    }
}
