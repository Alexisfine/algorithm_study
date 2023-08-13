package leetcode_questions.others.line_sweep_or_diff_array;

import java.util.Arrays;

public class _1589_Maximum_Sum_Obtained_Of_Any_Permutation {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int N = nums.length;
        int[] diff = new int[N + 1];
        for (int[] req : requests) {
            diff[req[0]]++;
            diff[req[1]+1]--;
        }
        int cur = 0;
        for (int i = 0; i < N; i++) {
            cur += diff[i];
            diff[i] = cur;
        }

        Arrays.sort(nums);
        Arrays.sort(diff);
        long res = 0;
        long mod = (long) 1e9 + 7;
        for (int i = nums.length - 1; i >= 0; i--) {
            res = (res + ((long) diff[i + 1] * nums[i]) % mod) % mod;
        }
        return (int) res;
    }


}
