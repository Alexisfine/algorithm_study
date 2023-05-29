package leetcode_questions.dynamic_programming.paint_house;

public class _256_Paint_House {
    // Time: O(M)
    // Space: O(M)
    public static int minCost(int[][] costs) {
        int M = costs.length;
        int[][] dp = new int[M][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < M; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(dp[M - 1][0], Math.min(dp[M - 1][1], dp[M - 1][2]));
    }

    // Time: O(M)
    // Space: O(1)
    public static int minCost2(int[][] costs) {
        int M = costs.length;
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];

        for (int i = 1; i < M; i++) {
            int preRed = red;
            int preBlue = blue;
            red = Math.min(blue, green) + costs[i][0];
            blue = Math.min(preRed, green) + costs[i][1];
            green = Math.min(preRed, preBlue) + costs[i][2];
        }

        return Math.min(red, Math.min(blue, green));
    }
}
