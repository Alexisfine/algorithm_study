package leetcode_questions.binary_search;

public class _33_Search_In_Rotated_Sorted_Array {
    // Time: O(log n)
    // Space: O(1)
    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] <= nums[mid]) {
                if (target < nums[mid] && nums[lo] <= target) hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if (target > nums[mid] && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 2, 3, 4};
        System.out.println(search(arr, 1));
    }
}
