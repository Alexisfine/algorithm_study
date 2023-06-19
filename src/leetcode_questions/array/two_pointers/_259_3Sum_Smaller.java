package leetcode_questions.array.two_pointers;

import java.util.Arrays;

public class _259_3Sum_Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    res += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
}
