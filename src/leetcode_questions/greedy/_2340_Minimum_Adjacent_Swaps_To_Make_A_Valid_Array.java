package leetcode_questions.greedy;

public class _2340_Minimum_Adjacent_Swaps_To_Make_A_Valid_Array {
    public int minimumSwaps(int[] nums) {
        if (nums.length < 2) return 0;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
            if (nums[i] < minValue) {
                minIndex = i;
                minValue = nums[i];
            }
        }

        int N = nums.length - 1;
        int res = 0;
        res += N - maxIndex;
        if (minIndex < maxIndex) {
            res += minIndex;
        } else {
            res += minIndex - 1;
        }
        return res;
    }
}
