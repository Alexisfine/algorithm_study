package leetcode_questions.binary_search;

public class _1060_Missing_Element_In_Sorted_Array {
    public int missingElement(int[] nums, int k) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[0] + k + left;

    }
}
