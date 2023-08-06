package leetcode_questions.companies.citadel;

public class GroupingOptions {
    public int groupingOptions(int n, int k) {
        if (n < k) return 0;

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                if (i >= j) {
                    dp[i][j] = dp[i - j][j] + dp[i - 1][j - 1];
                }
            }
        }
        return 0;
    }
}
