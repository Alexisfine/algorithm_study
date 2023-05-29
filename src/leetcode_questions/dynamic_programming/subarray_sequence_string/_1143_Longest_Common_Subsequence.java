package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _1143_Longest_Common_Subsequence {
    // Time: O(M*N)
    // Space: O(M*N)
    public static int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();

        int[][] dp = new int[M + 1][N + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        if (N > M) return longestCommonSubsequence(text2, text1);
        int[][] dp = new int[2][N + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) dp[0][j] = dp[1][j + 1] + 1;
                else {
                    dp[0][j] = Math.max(dp[0][j + 1], dp[1][j]);
                }
            }
            for (int j = N - 1; j >= 0; j--) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[0][0];
    }
}
