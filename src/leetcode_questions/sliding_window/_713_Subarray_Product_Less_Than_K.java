package leetcode_questions.sliding_window;

public class _713_Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int N = nums.length;
        int cumProduct = 1;
        int members = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            cumProduct *= nums[i];
            if (cumProduct < k) {
                members++;
                res += members;
            } else if (nums[i] < k){
                int index = i - members;
                while (index < i && cumProduct >= k) {
                    cumProduct /= nums[index++];
                    members--;
                }
                members++;
                res += members;
            } else {
                members = 0;
                cumProduct = 1;
            }
        }
        return res;
    }
}
