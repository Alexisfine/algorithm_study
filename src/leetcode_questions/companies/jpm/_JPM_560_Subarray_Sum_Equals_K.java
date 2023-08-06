package leetcode_questions.companies.jpm;

import java.util.HashMap;
import java.util.Map;

public class _JPM_560_Subarray_Sum_Equals_K {
    /**
     * prefix sum
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int res = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSum == k) res++;
            int diff = preSum - k;
            res += countMap.getOrDefault(diff, 0);
            countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
