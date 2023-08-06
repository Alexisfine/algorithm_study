package leetcode_questions.string;

public class _10_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        int M = s.length();
        int N = p.length();
        s = "_" + s;
        p = "_" + p;
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int i = 2; i <= N; i++) {
            dp[0][i] = p.charAt(i) == '*' && dp[0][i - 2];
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                char currentSChar = s.charAt(i);
                char currentPChar = p.charAt(j);
                if (currentSChar == currentPChar || currentPChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentPChar == '*') {
                    dp[i][j] = (currentSChar == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j];
                    if (j > 1) dp[i][j] = dp[i][j] || dp[i][j - 2];
                }
            }
        }
        return dp[M][N];
    }

    /*
    dp[i][j] whether s[0:i] and p[0:j] are matched

    dp[i - 1][j - 1]
    dp[i - 1][j]
    dp[i][j - 1]

    if s[i] == p[j] or p[j] == '#':
        dp[i][j] = dp[i - 1][j - 1]
    if p[j] == '*':
        dp[i][j] = (s[i] == p[j - 1] or p[j - 1] == '#') and dp[i - 1][j]
        dp[i][j] = dp[i][j] or dp[i][j - 2]

    s: X X X X i
    p: Y Y Y j

    s: X X X T Z
    p: Y Y Z *
     */
}
