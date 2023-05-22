package leetcode_questions.array;

public class _53_Maximum_Subarray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            cur += n;
            max = Math.max(max, cur);
            cur = Math.max(cur, 0);
        }
        return max;
    }
}
