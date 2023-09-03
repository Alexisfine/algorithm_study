package leetcode_questions.greedy;

import java.util.Arrays;

public class _2616_Minimize_The_Maximum_Difference_Of_Pairs {
    public int minimizeMax(int[] nums, int p) {
        if (p <= 1) return 0;
        Arrays.sort(nums);
        int lo = 0;
        int hi = Integer.MAX_VALUE / 2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isOK(nums, mid, p)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isOK(int[] nums, int distance, int p) {
        int curPairs = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= distance) {
                curPairs++;
                i += 2;
            } else {
                i++;
            }
        }
        return curPairs >= p;
    }
}
