package leetcode_questions.dynamic_programming.knapsack;

import java.util.Arrays;

public class _494_Target_Sum {
    // Time: O(T*N)
    // Space: O(T*N)
    public static int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        int[][] dp = new int[N][2002];
        int offset = 1000;
        dp[0][-1 * nums[0] + offset] = 1;
        dp[0][nums[0] + offset] += 1;
        for (int i = 1; i < N; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (j - nums[i] >= -1000) {
                    dp[i][j + offset] += dp[i - 1][j - nums[i] + offset];
                }
                if (j + nums[i] <= 1000) {
                    dp[i][j + offset] += dp[i - 1][j + nums[i] + offset];
                }
            }
        }
        return dp[N - 1][target + offset];
    }

    // Time: O(T*N)
    // Space: O(T)
    public static int findTargetSumWays2(int[] nums, int target) {
        int N = nums.length;
        int[][] dp = new int[2][2002];
        int offset = 1000;
        dp[0][-1 * nums[0] + offset] = 1;
        dp[0][nums[0] + offset] += 1;
        for (int i = 1; i < N; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (j - nums[i] >= -1000) {
                    dp[1][j + offset] += dp[0][j - nums[i] + offset];
                }
                if (j + nums[i] <= 1000) {
                    dp[1][j + offset] += dp[0][j + nums[i] + offset];
                }
            }
            for (int j = -1000; j <= 1000; j++) {
                dp[0][j + offset] = dp[1][j + offset];
                dp[1][j + offset] = 0;
            }
        }
        return dp[0][target + offset];
    }
}
