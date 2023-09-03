package leetcode_questions.greedy;

import java.util.*;

public class _659_Split_Array_Info_Consecutive_Subsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> seq = new HashMap<>(); //ending num : how many seqs
        Map<Integer, Integer> count = new HashMap<>(); // num : how many unchecked
        for (int i = 0; i < nums.length; i++) {
            count.putIfAbsent(nums[i], 0);
            count.put(nums[i], count.get(nums[i]) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == 0) continue;
            if (seq.containsKey(nums[i] - 1)) {
                int val = seq.get(nums[i] - 1);
                val--;
                if (val > 0) seq.put(nums[i] - 1, val);
                else seq.remove(nums[i] - 1);

                seq.putIfAbsent(nums[i], 0);
                seq.put(nums[i], seq.get(nums[i]) + 1);

                count.put(nums[i], count.get(nums[i]) - 1);
            } else {
                if (count.getOrDefault(nums[i] + 1, 0) == 0
                        || count.getOrDefault(nums[i] + 2, 0) == 0) {
                    return false;
                } else {
                    count.put(nums[i], count.get(nums[i]) - 1);
                    count.put(nums[i] + 1, count.get(nums[i] + 1) - 1);
                    count.put(nums[i] + 2, count.get(nums[i] + 2) - 1);
                    seq.putIfAbsent(nums[i] + 2, 0);
                    seq.put(nums[i] + 2, seq.get(nums[i] + 2) + 1);
                }
            }
        }
        return true;
    }
}
