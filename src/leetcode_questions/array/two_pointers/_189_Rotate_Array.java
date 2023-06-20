package leetcode_questions.array.two_pointers;

public class _189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = temp;
        }

        lo = 0;
        hi = k - 1;
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = temp;
        }

        lo = k;
        hi = nums.length - 1;
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = temp;
        }
    }
}
