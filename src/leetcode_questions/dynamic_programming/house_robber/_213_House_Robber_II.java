package leetcode_questions.dynamic_programming.house_robber;

public class _213_House_Robber_II {

    public static int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int N = nums.length;

        int[] dp = new int[N - 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int res1 = dp[N - 2];

        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < N - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + 1]);
        }
        int res2 = dp[N - 2];

        return Math.max(res1, res2);
    }

    // Time: O(N)
    // Space: O(1)
    public static int rob2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int N = nums.length;


        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N - 1; i++) {
            int temp = Math.max(second, first + nums[i]);
            first = second;
            second = temp;
        }
        int res1 = second;

        first = nums[1];
        second = Math.max(nums[1], nums[2]);
        for (int i = 2; i < N - 1; i++) {
            int temp = Math.max(second, first + nums[i + 1]);
            first = second;
            second = temp;
        }
        int res2 = second;

        return Math.max(res1, res2);
    }

}
