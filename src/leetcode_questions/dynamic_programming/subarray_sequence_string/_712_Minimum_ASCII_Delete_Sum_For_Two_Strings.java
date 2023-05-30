package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _712_Minimum_ASCII_Delete_Sum_For_Two_Strings {

    // Time: O(M * N)
    // Space: O(M * N)
    public static int minimumDeleteSum(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = N - 1; i >= 0; i--) {
            dp[M][i] = dp[M][i + 1] + s2.charAt(i);
        }
        for (int i = M - 1; i >= 0; i--) {
            dp[i][N] = dp[i + 1][N] + s1.charAt(i);
        }

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int deleteI = dp[i + 1][j] + s1.charAt(i);
                    int deleteJ = dp[i][j + 1] + s2.charAt(j);
                    dp[i][j] = Math.min(deleteI, deleteJ);
                }
            }
        }
        return dp[0][0];
    }

    // Time: O(M * N)
    // Space: O(N)
    public static int minimumDeleteSum2(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        if (N > M) return minimumDeleteSum2(s2, s1);
        int[][] dp = new int[2][N + 1];
        for (int i = N - 1; i >= 0; i--) {
            dp[1][i] = dp[1][i + 1] + s2.charAt(i);
        }

        for (int i = M - 1; i >= 0; i--) {
            dp[0][N] = dp[1][N] + s1.charAt(i);
            for (int j = N - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[0][j] = dp[1][j + 1];
                } else {
                    int deleteI = dp[1][j] + s1.charAt(i);
                    int deleteJ = dp[0][j + 1] + s2.charAt(j);
                    dp[0][j] = Math.min(deleteI, deleteJ);
                }
            }

            for (int j = 0; j <= N; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[0][0];
    }
}
