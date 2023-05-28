package leetcode_questions.dynamic_programming;

import java.util.Arrays;

public class _1335_Minimum_Difficulty_Of_A_Job_Schedule {
    // Time: O(N^2 *D)
    // Space: O(N*D)
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;
        if (d > N) return -1;

        int[][] dp = new int[d + 1][N];
        int maxDifficulty = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            dp[d][i] = maxDifficulty;
        }

        for (int i = d - 1; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                maxDifficulty = Integer.MIN_VALUE;
                int minCost = Integer.MAX_VALUE;
                for (int k = j; N - k - 1 >= d - i; k++) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[k]);
                    minCost = Math.min(minCost, dp[i + 1][k + 1] + maxDifficulty);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][0];
    }

    // Time: O(N^2 * D)
    // Space: O(N)
    public static int minDifficulty2(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;
        if (d > N) return -1;

        int[][] dp = new int[2][N];
        int maxDifficulty = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            dp[1][i] = maxDifficulty;
        }

        for (int i = d - 1; i >= 1; i--) {
            for (int j = 0; j < N; j++) {
                maxDifficulty = Integer.MIN_VALUE;
                int minCost = Integer.MAX_VALUE;
                for (int k = j; N - k - 1 >= d - i; k++) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[k]);
                    minCost = Math.min(minCost, dp[1][k + 1] + maxDifficulty);
                }
                dp[0][j] = minCost;
            }
            for (int j = 0; j < N; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[1][0];
    }


}
