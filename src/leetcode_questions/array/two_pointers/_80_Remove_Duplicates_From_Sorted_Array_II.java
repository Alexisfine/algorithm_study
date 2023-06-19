package leetcode_questions.array.two_pointers;

public class _80_Remove_Duplicates_From_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int lo = 0;
        int hi = 0;
        int count = 0;
        while (hi < nums.length) {
            if (lo < nums.length - 2 && nums[lo] == nums[lo + 1]) {
                nums[count++] = nums[lo++];
                nums[count++] = nums[lo];
                hi = lo;
                while (hi < nums.length && nums[hi] == nums[lo]) hi++;
                lo = hi;
            } else {
                nums[count++] = nums[lo++];
                hi = lo;
            }
        }
        return count;
    }
}
