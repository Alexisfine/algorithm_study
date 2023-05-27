package leetcode_questions.dynamic_programming.knapsack;

public class _474_Ones_And_Zeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length < 1) return 0;
        int N = strs.length;
        int[][][] dp = new int[N][m + 1][n + 1];

        int zeros = 0;
        int ones = 0;
        int max = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == '0') zeros++;
            else ones++;
        }
        if (zeros <= m && ones <= n) {
            dp[0][zeros][ones] = 1;
            max = 1;
        }

        for (int i = 1; i < N; i++) {
            zeros = 0;
            ones = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') zeros++;
                else ones++;
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - zeros >= 0 && k - ones >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], 1 + dp[i - 1][j - zeros][k - ones]);
                    }
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        return max;
    }

    // Time: O(M*N*O)
    // Space: O(M*N)
    public int findMaxForm2(String[] strs, int m, int n) {
        if (strs == null || strs.length < 1) return 0;
        int N = strs.length;
        int[][][] dp = new int[2][m + 1][n + 1];

        int zeros = 0;
        int ones = 0;
        int max = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == '0') zeros++;
            else ones++;
        }
        if (zeros <= m && ones <= n) {
            dp[0][zeros][ones] = 1;
            max = 1;
        }

        for (int i = 1; i < N; i++) {
            zeros = 0;
            ones = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') zeros++;
                else ones++;
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[1][j][k] = dp[0][j][k];
                    if (j - zeros >= 0 && k - ones >= 0) {
                        dp[1][j][k] = Math.max(dp[1][j][k], 1 + dp[0][j - zeros][k - ones]);
                    }
                    max = Math.max(max, dp[1][j][k]);
                }
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[0][j][k] = dp[1][j][k];
                }
            }
        }
        return max;
    }
}
