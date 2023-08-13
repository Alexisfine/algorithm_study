package leetcode_questions.others.prefix_sum;


public class _2132_Stamping_The_Grid {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int M = grid.length;
        int N = grid[0].length;

        RegionSum regionSum = new RegionSum(grid);
        int[][] stamps = new int[M][N];
        for (int i=0; i+stampHeight-1<M; i++)
            for (int j=0; j+stampWidth-1<N; j++)
            {
                int x = i+stampHeight-1;
                int y = j+stampWidth-1;
                int area = regionSum.query(i, j, x, y);
                if (area == 0)
                    stamps[x][y] = 1;
            }

        RegionSum stamp = new RegionSum(stamps);
        for (int i=0; i<M; i++)
            for (int j=0; j<N; j++)
            {
                if (grid[i][j]==1) continue;
                int x = Math.min(M-1, i+stampHeight-1);
                int y = Math.min(N-1, j+stampWidth-1);
                int area = stamp.query(i, j, x, y);
                if (area == 0) return false;
            }
        return true;
    }

    class RegionSum {
        int M;
        int N;
        int[][] prefixSum;
        public RegionSum(int[][] grid) {
            M = grid.length;
            N = grid[0].length;
            prefixSum = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int a = i == 0 ? 0 : prefixSum[i - 1][j];
                    int b = j == 0 ? 0 : prefixSum[i][j - 1];
                    int c = (i == 0 || j == 0) ? 0 : prefixSum[i - 1][j - 1];
                    prefixSum[i][j] = a + b - c + grid[i][j];
                }
            }
        }

        public int query(int i, int j, int x, int y) {
            int a = j == 0 ? 0 : prefixSum[x][j - 1];
            int b = i == 0 ? 0 : prefixSum[i - 1][y];
            int c = (i == 0 || j == 0) ? 0 : prefixSum[i - 1][j - 1];
            return prefixSum[x][y] - a - b + c;
        }
    }
}
