package leetcode_questions.prefix_sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < N; i++) {
            prefixSum += nums[i];
            int curRem = prefixSum % k;
            if ((i > 0 && curRem == 0)) return true;
            if (remainderMap.containsKey(curRem)) {
                int index = remainderMap.get(curRem);
                if (i - index > 1) return true;
            }
            else remainderMap.put(curRem, i);
        }
        return false;
    }
}
