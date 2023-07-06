package leetcode_questions.dynamic_programming.interval;

public class _1092_Shortest_Common_Supersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        final int M = str1.length();
        final int N = str2.length();
        str1 = '#' + str1;
        str2 = '#' + str2;

        int[][] dp = new int[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= N; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        int i = M;
        int j = N;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.insert(0, str1.charAt(i));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j] + 1) {
                sb.insert(0, str1.charAt(i));
                i--;
            } else {
                sb.insert(0, str2.charAt(j));
                j--;
            }
        }

        while (i > 0) {
            sb.insert(0, str1.charAt(i));
            i--;
        }

        while (j > 0) {
            sb.insert(0, str2.charAt(j));
            j--;
        }

        return new String(sb);
    }

    /*

    dp[i][j] : the length of scs for str1[0:i] and str2[0:j]

    dp[i][j]:
    if str1[i] == str2[j]:
        dp[i][j] = dp[i - 1][j - 1]
    else:
        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1

     */
}
