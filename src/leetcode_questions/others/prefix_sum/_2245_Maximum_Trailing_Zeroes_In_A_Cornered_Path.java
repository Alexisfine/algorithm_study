package leetcode_questions.others.prefix_sum;

public class _2245_Maximum_Trailing_Zeroes_In_A_Cornered_Path {
    public int maxTrailingZeros(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][] self2 = new int[M][N];
        int[][] self5 = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int x = grid[i][j];
                while (x % 2 == 0) {
                    self2[i][j]++;
                    x /= 2;
                }
                while (x % 5 == 0) {
                    self5[i][j]++;
                    x /= 5;
                }
            }
        }

        int[][] left2 = new int[M][N];
        int[][] right2 = new int[M][N];
        int[][] up2 = new int[M][N];
        int[][] down2 = new int[M][N];
        int[][] left5 = new int[M][N];
        int[][] right5 = new int[M][N];
        int[][] up5 = new int[M][N];
        int[][] down5 = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                left2[i][j] = (j == 0 ? 0 : left2[i][j - 1]) + self2[i][j];
                left5[i][j] = (j == 0 ? 0 : left5[i][j - 1]) + self5[i][j];
            }
            for (int j = N - 1; j >= 0; j--) {
                right2[i][j] = (j == N - 1 ? 0 : right2[i][j + 1]) + self2[i][j];
                right5[i][j] = (j == N - 1 ? 0 : right5[i][j + 1]) + self5[i][j];
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                up2[i][j] = (i == 0 ? 0 : up2[i - 1][j]) + self2[i][j];
                up5[i][j] = (i == 0 ? 0 : up5[i - 1][j]) + self5[i][j];
            }
            for (int i = M - 1; i >= 0; i--) {
                down2[i][j] = (i == M - 1 ? 0 : down2[i + 1][j]) + self2[i][j];
                down5[i][j] = (i == M - 1 ? 0 : down5[i + 1][j]) + self5[i][j];
            }
        }

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, Math.min(left2[i][j] + up2[i][j] - self2[i][j],
                                left5[i][j] + up5[i][j] - self5[i][j]));
                res = Math.max(res, Math.min(right2[i][j] + up2[i][j] - self2[i][j],
                        right5[i][j] + up5[i][j] - self5[i][j]));
                res = Math.max(res, Math.min(left2[i][j] + down2[i][j] - self2[i][j],
                        left5[i][j] + down5[i][j] - self5[i][j]));
                res = Math.max(res, Math.min(right2[i][j] + down2[i][j] - self2[i][j],
                        right5[i][j] + down5[i][j] - self5[i][j]));
            }
        }
        return res;
    }
}
