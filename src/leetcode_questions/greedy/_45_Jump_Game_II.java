package leetcode_questions.greedy;

public class _45_Jump_Game_II {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int cur = 0;
        int next = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);
            if (i == cur) {
                if (i != nums.length - 1) {
                    res++;
                    cur = next;
                    if (cur >= nums.length - 1) break;
                } else break;
            }
        }
        return res;
    }
}
