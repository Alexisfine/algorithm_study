package leetcode_questions.sliding_window;

public class _1004_Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        if (nums.length < k) return nums.length;
        int maxLen = 0;
        int zeroes = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroes++;
            }
            while (zeroes > k) {
                if (nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
