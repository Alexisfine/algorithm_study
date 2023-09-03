package leetcode_questions.greedy;

import java.util.Arrays;

public class _1402_Reducing_Dishes {
    // Greedy
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int maxSatisfaction = 0;
        int suffixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0 && suffixSum + satisfaction[i] > 0; i--) {
            // Total satisfaction with all dishes so far.
            suffixSum += satisfaction[i];
            // Adding one instance of previous dishes as we add one more dish on the left.
            maxSatisfaction +=  suffixSum;
        }
        return maxSatisfaction;
    }

    // DP
    public int maxSatisfaction2(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int N = satisfaction.length;
        long[][] dp = new long[N + 1][N + 2];

        for (int i = 0; i <= N; i++) {
            dp[N - 1][i] = i * (long) satisfaction[N - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i + 1; j++) {
                dp[i][j] = Math.max(j * (long) satisfaction[i] + dp[i + 1][j + 1], dp[i + 1][j]);
            }
        }
        long res = Long.MIN_VALUE;
        for (int i = 0; i <= N; i++) {
            res = Math.max(res, dp[0][i]);
        }
        return (int) res;
    }
    /*
    dp[i][j] i-th index, j-th dish
    dp[i][j] = Math.max(i*satisfaction[i] + dp[i+1][j+1], dp[i][j+1])
    [-8,-7,-1,0,5]
     */
}
