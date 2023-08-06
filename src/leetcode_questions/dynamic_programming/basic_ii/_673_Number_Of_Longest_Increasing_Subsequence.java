package leetcode_questions.dynamic_programming.basic_ii;

public class _673_Number_Of_Longest_Increasing_Subsequence {
    public static int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[2][N];

        int maxLen = 1;
        for (int i = 0; i < N; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[0][j] > max) {
                        max = dp[0][j];
                        dp[1][i] = dp[1][j];
                    } else if (dp[0][j] == max) {
                        dp[1][i] += dp[1][j];
                    }
                }
            }
            dp[0][i] += max;
            maxLen = Math.max(maxLen, dp[0][i]);
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (dp[0][i] == maxLen) {
                res += dp[1][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2});
    }
}
