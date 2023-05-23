package leetcode_questions.dynamic_programming;

import java.util.Arrays;

public class _300_Longest_Increasing_Subsequence {
    // Time: O(N^2)
    // Space: O(N)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int N = nums.length;
        int[] dp = new int[N];
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = 1;

        // the lowest upper bound for ascending subsequence with length of i+1
        int[] endi = new int[N];
        return 0;
    }

















}
