package leetcode_questions.dynamic_programming.matrix;

public class _64_Minimum_Path_Sum {
    // Time: O(M * N)
    // Space: O(M * N)
    public static int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = grid[0][0];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }
        return dp[M - 1][N - 1];
    }

    // Time: O(M * N)
    // Space: O(N)
    public static int minPathSum2(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][] dp = new int[2][N];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        if (M == 1) return dp[0][N - 1];

        for (int i = 1; i < M; i++) {
            dp[1][0] = dp[0][0] + grid[i][0];
            for (int j = 1; j < N; j++) {
                dp[1][j] = Math.min(dp[0][j], dp[1][j - 1]) + grid[i][j];
            }
            for (int j = 0; j < N; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][N - 1];
    }
}
