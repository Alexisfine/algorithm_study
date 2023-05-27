package leetcode_questions.dynamic_programming.knapsack;

public class _518_Coin_Change_II {
    // Time: O(S*N)
    // Space: O(S*N)
    public static int change(int amount, int[] coins) {
        if (coins == null || coins.length < 1) return 0;
        int N = coins.length;
        int[][] dp = new int[N][amount + 1];
        for (int i = 0; i <= amount; i++) dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        for (int i = 0; i < N; i++) dp[i][0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - coins[i] >= 0) dp[i][j] += dp[i][j - coins[i]];
            }
        }
        return dp[N - 1][amount];
    }


}
