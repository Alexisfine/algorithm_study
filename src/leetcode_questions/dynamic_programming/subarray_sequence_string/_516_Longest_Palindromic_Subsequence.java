package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _516_Longest_Palindromic_Subsequence {
    public static int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
            if (i + 1 < N) {
                dp[i][i + 1] =  s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    public static int longestPalindromeSubseq2(String s) {
        int N = s.length();
        int[][] dp = new int[2][N];

        dp[1][N - 1] = 1;

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (i == j) {
                    dp[0][j] = 1;
                    continue;
                }
                if (i + 1 == j) {
                    dp[0][j] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[0][j] = dp[1][j - 1] + 2;
                } else {
                    dp[0][j] = Math.max(dp[1][j], dp[0][j - 1]);
                }
            }
            for (int j = i; j < N; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[1][N - 1];
    }


}
