package leetcode_questions.companies.amazon;

public class _1035_Uncrossed_Lines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        int[][] dp = new int[M][N];
        for (int i = M - 1; i >= 0 ; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1;
                    if (i + 1 < M && j + 1 < N) {
                        dp[i][j] += dp[i + 1][j + 1];
                    }
                } else {
                    if (i + 1 < M) dp[i][j] = dp[i + 1][j];
                    if (j + 1 < N) dp[i][j] = Math.max(dp[i][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
