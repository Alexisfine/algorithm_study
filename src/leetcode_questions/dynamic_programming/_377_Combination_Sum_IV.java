package leetcode_questions.dynamic_programming;

public class _377_Combination_Sum_IV {
    public static int combinationSum4(int[] nums, int target) {
        return process(nums, 0, target);
    }

    private static int process(int[] nums, int cur, int target) {
        if (cur == target) return 1;
        if (cur > target) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += process(nums, cur + nums[i], target);
        }
        return res;
    }

    // Time: O(N * N * T)
    // Space: O(N * T)
    public static int dpWay1(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int N = nums.length;
        int[][] dp = new int[target][target + 1];

        for (int i = 0; i < N; i++) {
            if (nums[i] <= target) dp[0][nums[i]] = 1;
        }

        for (int i = 1; i < target; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k < N; k++) {
                    if (j - nums[k] >= 0) dp[i][j] += dp[i - 1][j - nums[k]];
                }
                if (j == target) dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[target - 1][target];
    }

    // Time: O(N*T)
    // Space: O(T)
    public static int dpWay2(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int N = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < N; j++) {
                if (i - nums[j] >= 0) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];

    }
}
