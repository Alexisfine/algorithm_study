package leetcode_questions.greedy;

public class _334_Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
        int N = nums.length;
        if (N < 3) return false;

        int[] preMin = new int[N];
        int[] sufMax = new int[N];
        preMin[0] = Integer.MAX_VALUE;
        sufMax[N - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            preMin[i] = Math.min(preMin[i - 1], nums[i - 1]);
        }
        for (int i = N - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], nums[i + 1]);
        }

        for (int i = 1; i < N - 1; i++) {
            if (preMin[i] < nums[i] && nums[i] < sufMax[i]) return true;
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int N = nums.length;
        if (N < 3) return false;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (nums[i] <= firstMin) {
                firstMin = nums[i];
            } else if (nums[i] <= secondMin) {
                secondMin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
