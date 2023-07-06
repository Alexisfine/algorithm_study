package leetcode_questions.dynamic_programming.interval;

public class _1312_Minimum_Insertion_Steps_To_Make_A_String_Palindrome {
    public int minInsertions(String s) {
        int M = s.length();
        int[][] dp = new int[M][M + 1];

        for (int i = 0; i + 1 < M; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 0 : 1;
        }

        for (int len = 3; len <= M; len++) {
            for (int i = 0; i + len - 1 < M; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][M - 1];
    }
}
