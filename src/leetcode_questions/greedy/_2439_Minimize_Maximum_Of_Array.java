package leetcode_questions.greedy;

public class _2439_Minimize_Maximum_Of_Array {
    public int minimizeArrayValue(int[] nums) {
        int res = nums[0];
        long total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
            res = (int) Math.max(res, Math.ceil((double) total / (i + 1)));
        }
        return res;
    }
}
