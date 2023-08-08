package leetcode_questions.array.two_pointers;

import java.util.Arrays;

public class _1679_Max_Number_Of_K_Sum_Pairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int diff = nums[lo] + nums[hi] - k;
            if (diff == 0) {
                lo++;
                hi--;
                res++;
            } else if (diff > 0) {
                hi--;
            } else {
                lo++;
            }
        }
        return res;
    }
}
