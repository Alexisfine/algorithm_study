package leetcode_questions.dynamic_programming.matrix;

public class _63_Unique_Paths_II {
    // Time: O(M * N)
    // Space: O(M * N)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[M - 1][N - 1] == 1) return 0;

        int[][] dp = new int[M][N];
        dp[0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[M - 1][N - 1];
    }

    // Time: O(M * N)
    // Space: O(N)
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[M - 1][N - 1] == 1) return 0;

        int[][] dp = new int[2][N];
        dp[1][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i > 0) dp[1][j] += dp[0][j];
                if (j > 0) dp[1][j] += dp[1][j - 1];
            }
            for (int j = 0; j < N; j++) {
                dp[0][j] = dp[1][j];
                dp[1][j] = 0;
            }
        }
        return dp[0][N - 1];
    }
}
