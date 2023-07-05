package leetcode_questions.string;

public class _5_Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) dp[i][i] = true;
        int maxLen = 0;
        int maxStart = 0;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1 && !dp[i + 1][j - 1]) continue;
                    else {
                        dp[i][j] = true;
                        if (j - i < maxLen) {
                            maxLen = j - i;
                            maxStart = i;
                        }
                    }
                } else dp[i][j] = false;
            }
        }
        return s.substring(maxStart, maxStart + maxLen + 1);

    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int N = s.length();
        boolean[][] dp = new boolean[2][N];

        int maxLen = 0;
        int maxStart = 0;

        for (int i = N - 2; i >= 0; i--) {
            dp[0][i] = true;
            dp[1][i + 1] = true;
            for (int j = N - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1 && !dp[1][j - 1]) continue;
                    dp[0][j] = true;
                    if (j - i > maxLen) {
                        maxLen = j - i;
                        maxStart = i;
                    }
                }
            }
            for (int j = 0; j < N; j++) dp[1][j] = dp[0][j];
        }
        return s.substring(maxStart, maxStart + maxLen + 1);
    }
}
