package leetcode_questions.companies.amazon;

public class _2684_Maximum_Number_Of_Moves_In_A_Grid {
    public int maxMoves(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][2];
        for (int i = 0; i < M; i++) dp[i][0] = 1;
        int max = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[j][0] > 0) dp[j][1] = grid[j][i] > grid[j][i - 1] ? dp[j][0] + 1 : 0;
                if (j > 0 && dp[j - 1][0] > 0) {
                    dp[j][1] = grid[j][i] > grid[j - 1][i - 1] ?
                            Math.max(dp[j][1], dp[j - 1][0] + 1) : dp[j][1];
                }
                if (j < M - 1 && dp[j + 1][0] > 0) {
                    dp[j][1] = grid[j][i] > grid[j + 1][i - 1] ?
                            Math.max(dp[j][1], dp[j + 1][0] + 1) : dp[j][1];
                }
                max = Math.max(max, dp[j][1]);
            }
            for (int j = 0; j < M; j++) dp[j][0] = dp[j][1];
        }
        return max == 0 ? 0 : max - 1;
    }
}
