package leetcode_questions.dynamic_programming;

import java.util.List;

public class _2218_Maximum_Value_Of_K_Coins_From_Piles {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int M = piles.size();
        int[][] dp = new int[M + 1][k + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = k; j >= 0; j--) {
                int maxVal = 0;
                int maxPilesFromJ = Math.min(k - j, piles.get(i).size());
                int cumSum = 0;
                for (int a = 0; a <= maxPilesFromJ; a++) {
                    if (a > 0) cumSum += piles.get(i).get(a - 1);
                    maxVal = Math.max(maxVal, cumSum + dp[i + 1][j + a]);
                }
                dp[i][j] = maxVal;
            }
        }
        return dp[0][0];
    }
}
