package leetcode_questions.array.two_pointers;

public class _26_Remove_Duplicates_From_Sorted_Array {
    public static int removeDuplicates(int[] nums) {
        int lo = 0;
        int hi = 0;
        int count = 0;
        while (hi < nums.length) {
            while (hi < nums.length && nums[hi] == nums[lo]) hi++;
            nums[count] = nums[lo];
            count++;
            lo = hi;
        }
        return count;
    }
}
