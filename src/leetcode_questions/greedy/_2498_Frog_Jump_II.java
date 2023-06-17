package leetcode_questions.greedy;

public class _2498_Frog_Jump_II {
    public int maxJump(int[] stones) {
        int N = stones.length;
        if (N <= 3) return stones[N - 1];
        int maxDiff = 0;
        for (int i = 2; i < N; i++) {
            int curDiff = stones[i] - stones[i - 2];
            maxDiff = Math.max(curDiff, maxDiff);
        }
        return maxDiff;
    }
}
