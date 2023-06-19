package leetcode_questions.binary_search;

public class _154_Find_Minimum_In_Rotated_Sorted_Array_II {
    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        int currentBest = Integer.MAX_VALUE;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[lo]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];

    }


}
