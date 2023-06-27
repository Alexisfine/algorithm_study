package leetcode_questions.sliding_window;

import java.util.*;

public class _2009_Minimum_Number_Of_Operations_To_Array_Continuous {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) set.add(nums[i]);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int minOperations = Integer.MAX_VALUE;
        int end = 0;
        for (int start = 0; start < list.size(); start++) {
            while (end < list.size() && list.get(end) - list.get(start) + 1 <= nums.length) {
                minOperations = Math.min(minOperations, nums.length - (end - start + 1));
                end++;
            }
        }
        return minOperations;
    }
}
