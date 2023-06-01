package leetcode_questions.backtracking;

import java.util.Arrays;

public class _698_Partition_To_K_Equal_Sum_Subsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < 1) return false;
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        return process(nums, new boolean[N], k, target, 0, 0);
    }

    private static boolean process(int[] nums, boolean[] used, int k, int target, int curSum, int index) {
        // base case
        if (k == 0) return true;
        if (curSum == target) {
            return process(nums, used, k - 1, target,  0, 0);
        }

        for (int i = index; i < nums.length; i++) {
            if (used[i] || curSum + nums[i] <= target) continue;
            used[i] = true;
            if (process(nums, used, k, target, curSum + nums[i], index + 1)) return true;
            used[i] = false;
        }
        return false;
    }
}
