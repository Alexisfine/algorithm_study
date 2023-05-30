package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _97_Interleaving_String {
    String s1;
    String s2;
    String s3;
    int len1;
    int len2;
    int len3;
    int[][] cache;

    // Recursive
    // Time: O(M * N)
    // Space: O(M * N)
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.len1 = s1.length();
        this.len2 = s2.length();
        this.len3 = s3.length();
        this.cache = new int[s1.length() + 1][s2.length() + 1];
        return process(0, 0, 0);
    }


    // DP
    // Time: O(M * N)
    // Space: O(M * N)
    private boolean process(int index1, int index2, int index3) {
        if (index1 == len1 && index2 == len2 && index3 == len3) return true;
        if (index3 == len3) return false;
        if (index1 == len1 && index2 == len2) return false;
        if (cache[index1][index2] != 0) return cache[index1][index2] == 1;
        boolean outcome1 = false;
        boolean outcome2 = false;
        if (index1 < len1 && s1.charAt(index1) == s3.charAt(index3)) {
            outcome1 = process(index1 + 1, index2, index3 + 1);
        }
        if (index2 < len2 && s2.charAt(index2) == s3.charAt(index3)) {
            outcome2 = process(index1, index2 + 1, index3 + 1);
        }
        boolean res = outcome1 || outcome2;
        cache[index1][index2] = res ? 1 : -1;
        return res;
    }

    // DP
    // Time: O(M * N)
    // Space: O(M * N)
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[len1][len2];
    }
    // DP
    // Time: O(M * N)
    // Space: O(N)
    public boolean isInterleave3(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[2][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) dp[1][j] = true;
                else if (i == 0) {
                    dp[1][j] = dp[1][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[1][j] = dp[0][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[1][j] = (dp[1][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[0][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }

            for (int j = 0; j <= len2; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][len2];
    }
}
