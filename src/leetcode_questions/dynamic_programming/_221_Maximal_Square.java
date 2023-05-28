package leetcode_questions.dynamic_programming;

public class _221_Maximal_Square {
    // Time: O(M*N)
    // Space: O(N)
    public static int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        int max = 0;
        int[][] dp = new int[2][N + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    dp[0][j] = 0;
                }
                else dp[0][j] = Math.min(dp[1][j], Math.min(dp[1][j + 1], dp[0][j + 1])) + 1;
                max = Math.max(max, dp[0][j]);
            }
            for (int j = 0; j < N; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return (int) Math.pow(max, 2);
    }

}
