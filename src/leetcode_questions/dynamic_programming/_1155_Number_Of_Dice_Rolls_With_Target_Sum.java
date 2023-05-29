package leetcode_questions.dynamic_programming;

public class _1155_Number_Of_Dice_Rolls_With_Target_Sum {
    // Time: O(N * K * T)
    public static int numRollsToTarget(int n, int k, int target) {
        int modulo = (int) Math.pow(10, 9) + 7;

        int m = Math.max(k, target);
        long[][] dp = new long[n][m + 1];
        // setup
        for (int i = 1; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j - l <= 0) break;
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % modulo;
                }
            }
        }
        long res = dp[n - 1][target] % modulo;
        return (int) res;
    }

    // Time: O(N * T)
    public static int numRollsToTarget2(int n, int k, int target) {
        int modulo = (int) Math.pow(10, 9) + 7;

        int m = Math.max(k, target);
        long[][] dp = new long[n][m + 1];
        // setup
        for (int i = 1; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= m; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % modulo;
                if (j - k - 1 > 0) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - k - 1]) % modulo;
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + modulo : dp[i][j];
            }
        }
        long res = dp[n - 1][target] % modulo;
        res = res < 0 ? res + modulo : res;
        return (int) res;
    }
}
