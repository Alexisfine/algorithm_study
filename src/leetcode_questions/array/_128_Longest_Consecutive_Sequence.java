package leetcode_questions.array;

import java.util.HashSet;
import java.util.Set;

public class _128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) set.add(nums[i]);
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int len = 1;
                while (set.contains(nums[i] + len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
