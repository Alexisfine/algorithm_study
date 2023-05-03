package leetcode_questions.binary_search;

public class _34_Find_First_And_Last_Position_Of_Element_In_Sorted_Array {
    // Time: O(log n)
    // Space: O(1)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[]{-1, -1};
        int left = binarySearch(nums, target - 0.5);
        int right = binarySearch(nums, target + 0.5);
        if (left == right) return res;
        res[0] = left;
        res[1] = right - 1;
        return res;
    }

    private int binarySearch(int[] nums, double target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

}
