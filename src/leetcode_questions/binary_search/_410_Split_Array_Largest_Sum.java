package leetcode_questions.binary_search;

import java.util.Arrays;

public class _410_Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int k) {
        int hi = 0;
        int lo = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            lo = Math.max(nums[i], lo);
            hi += nums[i];
        }
        int res = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canSplit(nums, mid, k)){
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    private boolean canSplit(int[] nums, int mid, int k) {
        int subArr = 0;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > mid) {
                subArr++;
                curSum = nums[i];
            }
        }
        return subArr + 1 <= k;
    }
}
