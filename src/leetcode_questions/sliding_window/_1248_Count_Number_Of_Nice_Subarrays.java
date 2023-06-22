package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class _1248_Count_Number_Of_Nice_Subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return subarraysLessThanOrEqualToKOdds(nums, k) - subarraysLessThanOrEqualToKOdds(nums, k - 1);
    }

    private int subarraysLessThanOrEqualToKOdds(int[] nums, int k) {
        int start = 0;
        int res = 0;
        int oddNums = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 == 1) {
                oddNums++;
                while (oddNums > k) {
                    if (nums[start] % 2 == 1) {
                        oddNums--;
                    }
                    start++;
                }
            }
            res += end - start + 1;
        }
        return res;
    }
}
