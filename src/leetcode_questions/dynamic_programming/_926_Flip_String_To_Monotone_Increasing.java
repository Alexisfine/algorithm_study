package leetcode_questions.dynamic_programming;

public class _926_Flip_String_To_Monotone_Increasing {
    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        int[][] dp = new int[N][2];
        for (int i = N - 1; i >= 0; i--) {
            dp[i][0] = s.charAt(i) == '0' ? 0 : 1;
            dp[i][1] = s.charAt(i) == '1' ? 0 : 1;
            if (i + 1 < N) {
                dp[i][0] += Math.min(dp[i + 1][0], dp[i + 1][1]);
                dp[i][1] += dp[i + 1][1];
            }
        }
        return Math.min(dp[0][0], dp[0][1]);
    }

    public int minFlipsMonoIncr2(String s) {
        int N = s.length();
        int[][] dp = new int[2][2];
        for (int i = N - 1; i >= 0; i--) {
            dp[0][0] = s.charAt(i) == '0' ? 0 : 1;
            dp[0][1] = s.charAt(i) == '1' ? 0 : 1;
            dp[0][0] += Math.min(dp[1][0], dp[1][1]);
            dp[0][1] += dp[1][1];

            dp[1][0] = dp[0][0];
            dp[1][1] = dp[0][1];
        }
        return Math.min(dp[0][0], dp[0][1]);
    }
}
