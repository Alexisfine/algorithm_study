package leetcode_questions.others.count_subarray_by_element;

import java.util.Arrays;

public class _2681_Power_Of_Heroes {
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        long mod = (long) 1e9 + 7;
        long curSum = 0;
        int N = nums.length;


        for (int i = 0; i < N; i++) {
            if (i > 0) curSum = (curSum * 2 + nums[i - 1]) % mod;
            long square = (long) nums[i] * nums[i] % mod;
            res = res + curSum * square % mod + square * nums[i] % mod;
            res %= mod;
        }
        return (int) res;
    }

    /*
    max(nums[l_0], ....,nums[l_i])^2 * min(nums[l_0], ...,nums[l_i])

    [X Y Z i] X X X X
         j
     since we are finding subsets, sequences don't matter,
     we can sort the array first
     固定i，
     最小值为Z，Z*(2^0) * i^2
     最小值为Y, Y*(2^1) * i^2
     最小值为X, X*(2^2) * i^2
     */
}
