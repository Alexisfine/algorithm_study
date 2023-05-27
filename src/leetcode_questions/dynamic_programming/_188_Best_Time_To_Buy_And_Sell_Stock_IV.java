package leetcode_questions.dynamic_programming;

public class _188_Best_Time_To_Buy_And_Sell_Stock_IV {
    // Time: O(N*K)
    // Space: O(N*K)
    public static int maxProfit(int k, int[] prices) {
        if (k < 1) return 0;
        int N = prices.length;
        int[][] dp = new int[2 * k][N];
        dp[0][0] = prices[0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], prices[i]);
        }

        for (int i = 1; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[i][0] = prices[0];
                for (int j = 1; j < N; j++) {
                    dp[1][j] = Math.min(dp[1][j - 1], prices[j] - dp[i - 1][j]);
                }
            } else {
                dp[i][0] = 0;
                for (int j = 1; j < N; j++) {
                    dp[1][j] = Math.max(dp[1][j - 1], prices[j] - dp[i - 1][j]);
                }
            }
        }
        return dp[2 * k - 1][N - 1];
    }

    // Time: O(N*K)
    // Space: O(N)
    public static int maxProfit2(int k, int[] prices) {
        if (k < 1) return 0;
        int N = prices.length;
        int[][] dp = new int[2][N];
        dp[0][0] = prices[0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], prices[i]);
        }

        for (int i = 1; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[1][0] = prices[0];
                for (int j = 1; j < N; j++) {
                    dp[1][j] = Math.min(dp[1][j - 1], prices[j] - dp[0][j]);
                }
            } else {
                dp[1][0] = 0;
                for (int j = 1; j < N; j++) {
                    dp[1][j] = Math.max(dp[1][j - 1], prices[j] - dp[0][j]);
                }
            }

            for (int j = 0; j < N; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][N - 1];
    }
}
