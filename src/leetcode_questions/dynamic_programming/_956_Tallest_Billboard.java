package leetcode_questions.dynamic_programming;

import java.util.Arrays;

public class _956_Tallest_Billboard {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int element : rods) sum += element;
        int N = rods.length;
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            int rodHeight = rods[i - 1];
            for (int j = 0; j <= sum - rodHeight; j++) {
                if (dp[i - 1][j] == -1) continue;
                // Not used
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // Add to taller one
                dp[i][j + rodHeight] = Math.max(dp[i][j + rodHeight], dp[i - 1][j]);
                // Add to shorter one
                dp[i][Math.abs(j - rodHeight)] = Math.max(dp[i][Math.abs(j - rodHeight)],
                        dp[i - 1][j] + Math.min( rodHeight, j));
            }
        }
        return dp[N][0];
    }
}