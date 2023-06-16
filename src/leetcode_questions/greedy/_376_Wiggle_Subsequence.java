package leetcode_questions.greedy;

public class _376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int preDiff = 0;
        int postDiff = 0;
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            postDiff = nums[i + 1] - nums[i];
            if ((preDiff >= 0 && postDiff < 0) || (preDiff <= 0 && postDiff > 0)) {
                res++;
                preDiff = postDiff;
            }
        }
        return res;
    }
}
