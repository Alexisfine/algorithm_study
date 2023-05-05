package leetcode_questions.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _532_K_diff_Pairs_In_An_Array {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i] - k);
        }
        int ways = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() <= entry.getValue() && map.containsKey(entry.getValue())) ways++;
        }
        return ways;
    }
}
