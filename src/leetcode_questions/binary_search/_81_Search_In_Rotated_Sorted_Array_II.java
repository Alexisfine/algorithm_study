package leetcode_questions.binary_search;

public class _81_Search_In_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (hi > lo && nums[hi] == nums[lo]) {
            hi--;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            if (nums[lo] <= nums[mid]) {
                if (target < nums[mid] && nums[lo] <= target) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if (target > nums[mid] && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }
}
