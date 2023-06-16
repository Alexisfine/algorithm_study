package leetcode_questions.binary_search;

public class _153_Find_Minimum_In_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums.length == 1) return nums[0];

        int min = nums[0];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                min = nums[mid];
                break;
            } else if (nums[mid] >= nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return min;
    }
}
