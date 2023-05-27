package leetcode_questions.dynamic_programming.knapsack;

public class _279_Perfect_Squares {
    // Time: O(N * N^1/2)
    // Space: O(N)
    public static int numSquares(int n) {
        int largestBase = (int) Math.sqrt(n);
        int[] squares = new int[largestBase];
        for (int i = 0; i < largestBase; i++) squares[i] = (int) Math.pow(i + 1, 2);
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) dp[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < squares.length; j++) {
                if (i - squares[j] < 0) break;
                if (i == squares[j]) {
                    dp[i] = 1;
                    break;
                }
                else dp[i] = Math.min(dp[i], 1 + dp[i - squares[j]]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }



}
