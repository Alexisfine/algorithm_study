package leetcode_questions.sliding_window;

import java.util.Arrays;

public class _209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            curSum += nums[right];
            if (curSum >= target) {
                while (curSum - nums[left] >= target) {
                    curSum -= nums[left];
                    left++;
                }
                minLen = Math.min(minLen, right - left + 1);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
