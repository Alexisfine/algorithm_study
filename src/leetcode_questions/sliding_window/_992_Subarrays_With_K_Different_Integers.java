package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class _992_Subarrays_With_K_Different_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return arraysLessThanOrEqualTo(nums, k) - arraysLessThanOrEqualTo(nums, k - 1);
    }

    private int arraysLessThanOrEqualTo(int[] nums, int k) {
        int start = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.size() > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }
}
