package leetcode_questions.dynamic_programming.matrix;

import java.util.List;

public class _120_Triangle {
    // Time: O(M^2)
    // Space: O(M^2)
    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int[][] dp = new int[M][M];

        int min = Integer.MAX_VALUE;
        // base case
        for (int i = 0; i < M; i++) {
            dp[M - 1][i] = triangle.get(M - 1).get(i);
            if (M == 1) min = Math.min(min, dp[M - 1][i]);
        }

        for (int i = M - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = dp[i + 1][j];
                dp[i][j] = Math.min(dp[i][j], dp[i + 1][j + 1]);
                dp[i][j] += triangle.get(i).get(j);
                if (i == 0) min = Math.min(min, dp[i][j]);
            }
        }
        return min;
    }

    // Time: O(M^2)
    // Space: O(M)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int M = triangle.size();
        int[][] dp = new int[2][M];

        int min = Integer.MAX_VALUE;
        // base case
        for (int i = 0; i < M; i++) {
            dp[1][i] = triangle.get(M - 1).get(i);
            if (M == 1) min = Math.min(min, dp[1][i]);
        }

        for (int i = M - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[0][j] = dp[1][j];
                dp[0][j] = Math.min(dp[0][j], dp[1][j + 1]);
                dp[0][j] += triangle.get(i).get(j);
                if (i == 0) min = Math.min(min, dp[i][j]);
            }
            for (int j = 0; j <= i; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return min;
    }
}
