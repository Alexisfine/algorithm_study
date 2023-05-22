package string;

public class EditCost {
    public static int minCost1(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) return 0;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 1;

        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) dp[i][0] = i * dc;
        for (int j = 1; j < col; j++) dp[0][j] = j * ic;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j - 1] + rc;
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }
}
