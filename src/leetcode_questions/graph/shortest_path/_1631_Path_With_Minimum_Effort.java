package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _1631_Path_With_Minimum_Effort {
    public int minimumEffortPath(int[][] heights) {
        int M = heights.length;
        int N = heights[0].length;
        int[][] efforts = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }

        efforts[0][0] = 0;
        // effort, row, col
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] curPos = pq.poll();
            int effort = curPos[0], row = curPos[1], col = curPos[2];
            if (effort > efforts[row][col]) continue;
            efforts[row][col] = Math.min(effort, efforts[row][col]);

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (isValid(M, N, nextRow, nextCol)) {
                    int nextEffort = Math.max(effort, Math.abs(heights[row][col] - heights[nextRow][nextCol]));
                    if (nextEffort < efforts[nextRow][nextCol]) {
                        pq.offer(new int[]{nextEffort, nextRow, nextCol});
                    }
                }
            }
        }
        return efforts[M - 1][N - 1];
    }

    private boolean isValid(int m, int n, int i, int j) {
        return (i >= 0 && j >= 0 && i < m && j < n);
    }
}
