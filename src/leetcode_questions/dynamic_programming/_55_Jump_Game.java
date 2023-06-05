package leetcode_questions.dynamic_programming;

public class _55_Jump_Game {
    // Time: O(N^2)
    // Space: O(N)
    public boolean canJump(int[] nums) {
        int N = nums.length;
        boolean[] dp = new boolean[N];
        dp[0] = true;
        for (int i = 0; i < N; i++) {
            if (!dp[i]) continue;
            for (int j = 1; j <= nums[i] && i + j < N; j++) {
                dp[i + j] = true;
            }
        }
        return dp[N - 1];
    }
}
