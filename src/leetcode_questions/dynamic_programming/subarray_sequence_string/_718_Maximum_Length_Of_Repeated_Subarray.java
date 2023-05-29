package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _718_Maximum_Length_Of_Repeated_Subarray {
    public int findLength(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        int max = 0;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                    max = Math.max(max, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }
        return max;
    }

    public static int findLength2(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        int max = 0;
        int[][] dp = new int[2][N];
        for (int i = 0; i < N; i++) {
            if (nums1[0] == nums2[i]) {
                dp[0][i] = 1;
                max = Math.max(max, dp[0][i]);
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[1][j] = 1;
                    if (j > 0) {
                        dp[1][j] += dp[0][j - 1];
                    }
                    max = Math.max(max, dp[1][j]);
                } else dp[1][j] = 0;
            }
            for (int j = 0; j < N; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return max;
    }
}
