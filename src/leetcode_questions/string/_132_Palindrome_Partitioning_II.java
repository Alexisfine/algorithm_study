package leetcode_questions.string;

public class _132_Palindrome_Partitioning_II {
    // Time: O(N^2)
    // Space: O(N^2)
    public static int minCut(String s) {
        if (s == null || s.length() < 1) return 0;
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) dp[i][i] = true;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1 && !dp[i + 1][j - 1]) dp[i][j] = false;
                    else dp[i][j] = true;
                } else dp[i][j] = false;
            }
        }
        int[] dp2 = new int[N];
        dp2[0] = 0;
        for (int i = 1; i < N; i++) {
            if (dp[0][i]) {
                dp2[i] = 0;
                continue;
            }
            dp2[i] = dp2[i - 1] + 1;
            for (int j = 1; j <= i; j++) {
                if (dp[j][i]) {
                    dp2[i] = Math.min(dp2[i], dp2[j - 1] + 1);
                }
            }
        }
        return dp2[N - 1];
    }
}
