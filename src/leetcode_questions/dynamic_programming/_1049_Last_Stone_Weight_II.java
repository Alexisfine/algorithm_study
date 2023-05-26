package leetcode_questions.dynamic_programming;

public class _1049_Last_Stone_Weight_II {
    // Time: O(N*M)
    // Space: O(N*M)
    public static int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length < 1) return 0;
        if (stones.length == 1) return stones[0];

        int N = stones.length;
        int sum = 0;
        for (int i = 0; i < N; i++) sum += stones[i];
        int mid = sum / 2;

        boolean[][] dp = new boolean[N][mid + 1];
        for (int i = 0; i < N; i++) dp[i][0] = true;
        dp[0][stones[0]] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= mid; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - stones[i] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - stones[i]];
                }
            }
        }

        for (int i = mid; i >= 0; i--) {
            if (dp[N - 1][i]) {
                return Math.abs(sum - i - i);
            }
        }
        return 0;
    }
}
