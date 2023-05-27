package leetcode_questions.dynamic_programming.house_robber;

public class _198_House_Robber {
    // Time: O(N)
    // Space: O(N)
    public static int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[N - 1];
    }

    // Time: O(N)
    // Space: O(1)
    public static int rob2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int N = nums.length;
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N; i++) {
            int cur = Math.max(second, first + nums[i]);
            first = second;
            second = cur;
        }

        return second;
    }
}
