package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _115_Distinct_Subsequences {
    // Time: O(M * N)
    // Space: O(M * N)
    public static int numDistinct(String s, String t) {
        int M = s.length();
        int N = t.length();
        if (N > M) return 0;
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            dp[i][N] = 1;
        }

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    // Time: O(M * N)
    // Space: O(N)
    public static int numDistinct2(String s, String t) {
        int M = s.length();
        int N = t.length();
        if (N > M) return 0;
        int[][] dp = new int[2][N + 1];

        for (int i = M - 1; i >= 0; i--) {
            dp[1][N] = 1;
            for (int j = N - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[0][j] = dp[1][j + 1] + dp[1][j];
                } else {
                    dp[0][j] = dp[1][j];
                }
            }
            for (int j = 0; j <= N; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[0][0];
    }
}
