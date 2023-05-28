package leetcode_questions.dynamic_programming;

public class _276_Paint_Fence {
    public static int numWays(int n, int k) {
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2];
        }
        return dp[n - 1];
    }
}
