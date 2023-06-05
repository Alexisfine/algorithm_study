package leetcode_questions.dynamic_programming;

import java.util.Arrays;

public class _45_Jump_Game_II {
    // Time: O(N^2)
    // Space: O(N)
    public int jump(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 1; j <= nums[i] && i + j < N; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[N - 1];
    }
}
