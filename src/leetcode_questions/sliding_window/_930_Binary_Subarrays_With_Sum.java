package leetcode_questions.sliding_window;

public class _930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subarraysWithSumLessThanOrEqualTo(nums, goal)
                - subarraysWithSumLessThanOrEqualTo(nums, goal - 1);
    }

    private int subarraysWithSumLessThanOrEqualTo(int[] nums, int goal) {
        if (goal < 0) return 0;
        int start = 0;
        int res = 0;
        int currentSum = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            while (currentSum > goal) {
                currentSum -= nums[start];
                start++;
            }
            res += end - start + 1;
        }
        return res;
    }
}
