package leetcode_questions.sorting;

public class _41_Find_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (1 <= value && value <= nums.length) {
                if (nums[value - 1] > 0) nums[value - 1] *= -1;
                else if (nums[value - 1] == 0) nums[value - 1] = -1 * (nums.length + 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return nums.length + 1;
    }
}
