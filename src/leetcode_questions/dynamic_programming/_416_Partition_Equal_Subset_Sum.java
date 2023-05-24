package leetcode_questions.dynamic_programming;

public class _416_Partition_Equal_Subset_Sum {

    // Time: O(M*N)
    // Space: O(M*N)
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) sum += nums[i];
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[N][target + 1];
        if (nums[0] <= target) dp[0][nums[0]] = true;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i] >= 0) dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
            }
        }
        return dp[N - 1][target];
    }
}
