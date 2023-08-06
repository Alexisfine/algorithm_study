package leetcode_questions.dynamic_programming;

public class _879_Profitable_Schemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;
        int M = group.length;
        int[][][] dp = new int[101][101][101];

        for (int i = 0; i <= n; i++) {
            dp[M][i][minProfit] = 1;
        }

        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i + 1][j][k];
                    if (j + group[i] <= n) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i + 1][j + group[i]][Math.min(minProfit, k + profit[i])]) % mod;
                    }
                }
            }
        }
        return dp[0][0][0];
    }
}
