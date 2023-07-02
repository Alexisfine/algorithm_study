package leetcode_questions.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class _525_Contiguous_Array {
    public int findMaxLength(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            curSum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(curSum)) {
                int index = map.get(curSum);
                maxLen = Math.max(maxLen, i - index);
            } else if (curSum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (!map.containsKey(curSum)) map.put(curSum, i);
        }
        return maxLen;
    }
}
