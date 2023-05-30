package leetcode_questions.dynamic_programming.matrix;

public class _931_Minimum_Falling_Path_Sum {
    public static int minFallingPathSum(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M][N];
        int min = Integer.MAX_VALUE;
        // base case
        for (int i = 0; i < N; i++) {
            dp[M - 1][i] = matrix[M - 1][i];
            min = Math.min(min, dp[M - 1][i]);
        }

        if (M == 1) return min;
        min = Integer.MAX_VALUE;
        for (int i = M - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
                if (j < N - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j + 1]);
                }
                dp[i][j] += matrix[i][j];
                if (i == 0) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }

    // Time: O(M * N)
    // Space: O(N)
    public static int minFallingPathSum2(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[2][N];
        int min = Integer.MAX_VALUE;
        // base case
        for (int i = 0; i < N; i++) {
            dp[1][i] = matrix[M - 1][i];
            min = Math.min(min, dp[1][i]);
        }

        if (M == 1) return min;
        min = Integer.MAX_VALUE;

        for (int i = M - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                dp[0][j] = dp[1][j];
                if (j > 0) {
                    dp[0][j] = Math.min(dp[0][j], dp[1][j - 1]);
                }
                if (j < N - 1) {
                    dp[0][j] = Math.min(dp[0][j], dp[1][j + 1]);
                }
                dp[0][j] += matrix[i][j];
                if (i == 0) {
                    min = Math.min(min, dp[0][j]);
                }
            }
            for (int j = 0; j < N; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return min;
    }
}
