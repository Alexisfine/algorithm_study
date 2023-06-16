package leetcode_questions.greedy;

public class _55_Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int canReach = 0;
        for (int i = 0; i <= canReach && i < nums.length; i++) {
            canReach = Math.max(canReach, i + nums[i]);
        }
        return canReach >= nums.length - 1;
    }
}
