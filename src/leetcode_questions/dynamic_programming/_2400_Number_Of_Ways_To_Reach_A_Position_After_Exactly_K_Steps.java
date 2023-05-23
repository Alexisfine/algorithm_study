package leetcode_questions.dynamic_programming;

public class _2400_Number_Of_Ways_To_Reach_A_Position_After_Exactly_K_Steps {

    // Time: O(N^2)
    // Space: O(N^2)
    public static int numberOfWays(int startPos, int endPos, int k) {
        int mod = 1000000007;
        startPos += k;
        endPos += k;
        int len = Math.max(startPos, endPos) + k;
        int[][] dp = new int[k + 1][len + 1];
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= len; j++) {
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j < len) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[k][endPos] % mod;
    }

}
