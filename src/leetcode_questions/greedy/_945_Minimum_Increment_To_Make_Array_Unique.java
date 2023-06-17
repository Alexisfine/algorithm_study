package leetcode_questions.greedy;

import java.util.Arrays;

public class _945_Minimum_Increment_To_Make_Array_Unique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int increments = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                increments += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return increments;
    }
}
