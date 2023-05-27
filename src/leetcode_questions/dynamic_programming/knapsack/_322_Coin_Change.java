package leetcode_questions.dynamic_programming.knapsack;

import java.util.Arrays;

public class _322_Coin_Change {
    public int coinChange1(int[] coins, int amount) {
        int res = process(coins, 0, 0, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int process(int[] coins, int index, int current, int amount, int times) {
        if (current == amount) return times;
        if (current > amount) return Integer.MAX_VALUE;
        if (index == coins.length) return Integer.MAX_VALUE;
        return Math.min(
                process(coins, index, current + coins[index], amount, times + 1),
                process(coins, index + 1, current, amount, times));
    }


    // Time: O(S*N)
    // Space: O(S*N)

    public static int dpWay(int[] coins, int amount) {
        if (coins == null || coins.length < 1) return 0;
        int N = coins.length;
        int[][] dp = new int[N][amount + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j % coins[i] == 0) dp[i][j] = j / coins[i];
                else dp[i][j] = -1;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= amount; j++) {
                if (dp[i][j] == -1) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] >= 0) {
                    if (dp[i][j] >= 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                    else dp[i][j] = dp[i][j - coins[i]] + 1;
                }
            }
        }
        return dp[N - 1][amount];
    }

    // Time: O(S*N)
    // Space: O(S)
    public static int dpWay2(int[] coins, int amount) {
        if (coins == null || coins.length < 1) return 0;
        int N = coins.length;
        if (coins.length == 1) return amount % coins[0] == 0 ? amount / coins[0] : -1;

        int[][] dp = new int[2][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = -1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[1][j] = j % coins[i] == 0 ? j / coins[i] : -1;
                if (dp[1][j] == -1) dp[1][j] = dp[0][j];
                else dp[1][j] = Math.min(dp[1][j], dp[0][j]);
                if (j - coins[i] >= 0 && dp[1][j - coins[i]] >= 0) {
                    if (dp[1][j] >= 0) dp[1][j] = Math.min(dp[1][j], dp[1][j - coins[i]] + 1);
                    else dp[1][j] = dp[1][j - coins[i]] + 1;
                }
            }
            for (int j = 0; j <= amount; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[0][amount];

    }

}
