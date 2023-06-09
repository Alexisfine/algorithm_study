package leetcode_questions.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class _560_Subarray_Sum_Equals_K {
    // Time: O(N)
    // Space: O(N)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) count++;
            int complement = prefixSum - k;
            count += map.getOrDefault(complement, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
