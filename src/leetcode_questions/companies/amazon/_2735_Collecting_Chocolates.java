package leetcode_questions.companies.amazon;

import java.util.Arrays;

public class _2735_Collecting_Chocolates {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] += 1L * i * x;
            int cur = nums[i];
            for (int k = 0; k < n; k++) {
                cur = Math.min(cur, nums[(i - k + n) % n]);
                res[k] += cur;
            }
        }

        long min_res = Long.MAX_VALUE;
        for (long element : res) {
            min_res = Math.min(min_res, element);
        }

        return min_res;
    }
}
