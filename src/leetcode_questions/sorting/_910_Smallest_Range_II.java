package leetcode_questions.sorting;

import java.util.Arrays;

public class _910_Smallest_Range_II {
    public int smallestRangeII(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        int diff = nums[N - 1] - nums[0];
        for (int i = 0; i < N - 1; i++) {
            int max = Math.max(nums[i] + k, nums[N - 1] - k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            diff = Math.min(diff, max - min);
        }
        return diff;
    }

}
