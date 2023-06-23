package leetcode_questions.sliding_window;

public class _1493_Longest_Subarray_Of_Ones_After_Deleting_One_Element {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int zero = -1;
        int maxLen = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                if (zero == -1) {
                    zero = end;
                } else {
                    maxLen = Math.max(maxLen, end - start - 1);
                    start = zero + 1;
                    zero = end;
                }
            } else {
                if (zero == -1) {
                    maxLen = Math.max(maxLen, end - start + 1);
                } else {
                    maxLen = Math.max(maxLen, end - start);
                }
            }
        }
        if (zero == -1) maxLen--;
        return maxLen;
    }
}
