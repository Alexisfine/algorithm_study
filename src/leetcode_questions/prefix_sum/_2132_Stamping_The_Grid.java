package leetcode_questions.prefix_sum;

import leetcode_questions.template.RegionSum;

public class _2132_Stamping_The_Grid {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int M = grid.length;
        int N = grid[0].length;

        RegionSum regionSum = new RegionSum(grid);

        int[][] stamp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int x = i + stampHeight - 1;
                int y = j + stampWidth - 1;
                if (x >= M || y >= N) continue;
                int area = regionSum.query(i, j, x, y);
                if (area == 0) stamp[x][y] = 1;
            }
        }

        RegionSum stamps = new RegionSum(stamp);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) continue;
                int x = Math.min(M - 1, i + stampHeight - 1);
                int y = Math.min(N - 1, j + stampWidth - 1);
                int area = regionSum.query(i, j, x, y);
                if (area == 0) return false;
            }
        }
        return true;
    }
}
