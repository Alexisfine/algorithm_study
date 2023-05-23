package leetcode_questions.dynamic_programming;

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

    public static int dpWay(int[] coins, int amount) {
        if (coins == null || coins.length < 1) return 0;
        int N = coins.length;
        int[][] dp = new int[N][amount + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j % coins[i] == 0) dp[i][j] = j / coins[i];
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (j - coins[i] >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                }
            }
        }

        return dp[N - 1][amount];
    }

    public static void main(String[] args) {
        System.out.println(dpWay(new int[]{186, 419, 83, 408}, 6249));
    }




}
