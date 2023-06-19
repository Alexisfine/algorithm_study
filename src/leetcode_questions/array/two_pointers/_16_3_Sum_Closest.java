package leetcode_questions.array.two_pointers;

import java.util.Arrays;

public class _16_3_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff == 0) return target;
                if (diff < closest) {
                    closestSum = sum;
                    closest = diff;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closestSum;
    }
}
