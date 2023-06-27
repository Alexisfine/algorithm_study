package leetcode_questions.binary_search;

public class _540_Single_Element_In_A_Sorted_Array {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length - 1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
             int mid = lo + (hi - lo) / 2;
             boolean hasPair = false;
             if (mid > 0 && nums[mid] == nums[mid - 1]) {
                 hasPair = true;
             }
             if (mid < N && nums[mid] == nums[mid + 1]) {
                 hasPair = true;
                 mid++;
             }
             if (!hasPair) return nums[mid];
             if (mid % 2 == 1) {
                 lo = mid + 1;
             } else {
                 hi = mid - 2;
             }
        }
        return -1;
    }
}
