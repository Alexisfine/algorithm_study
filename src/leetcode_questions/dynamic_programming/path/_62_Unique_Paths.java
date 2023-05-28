package leetcode_questions.dynamic_programming.path;

public class _62_Unique_Paths {
    // Time: O(M * N)
    // Space: O(M * N)
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Time: O(M * N)
    // Space: O(N)
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][j] += dp[0][j];
                if (j > 0) dp[1][j] += dp[1][j - 1];
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = dp[1][j];
                dp[1][j] = 0;
            }
        }
        return dp[0][n - 1];
    }
}
