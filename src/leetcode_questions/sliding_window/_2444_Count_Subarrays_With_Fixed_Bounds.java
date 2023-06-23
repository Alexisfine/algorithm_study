package leetcode_questions.sliding_window;

public class _2444_Count_Subarrays_With_Fixed_Bounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int boundary = -1;
        int prevMin = -1;
        int prevMax = -1;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                boundary = i;
                prevMax = -1;
                prevMin = -1;
                continue;
            }
            if (nums[i] == minK) prevMin = i;
            if (nums[i] == maxK) prevMax = i;
            if (prevMax != -1 && prevMin != -1) {
                res += Math.min(prevMin, prevMax) - boundary;
            }
        }
        return res;
    }
}
