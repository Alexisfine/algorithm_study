package leetcode_questions.dynamic_programming;

public class _2140_Solving_Questions_With_Brainpower {
    // Time: O(N)
    // Space: O(N)
    public long mostPoints(int[][] questions) {
        int N = questions.length;
        long[] dp = new long[N];
        dp[N - 1] = questions[N - 1][0];

        for (int i = N - 2; i >= 0; i--) {
            dp[i] = questions[i][0];
            if (i + questions[i][1] + 1 < N) dp[i] += dp[i + questions[i][1] + 1];
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        return dp[0];
    }
}
