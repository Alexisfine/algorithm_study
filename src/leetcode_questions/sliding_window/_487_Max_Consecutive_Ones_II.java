package leetcode_questions.sliding_window;

public class _487_Max_Consecutive_Ones_II {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean hasFlipped = false;
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curLen++;
                maxLen = Math.max(curLen, maxLen);
            } else {
                if (!hasFlipped) {
                    curLen++;
                    hasFlipped = true;
                    maxLen = Math.max(curLen, maxLen);

                } else {
                    while (nums[start] != 0) {
                        start++;
                        curLen--;
                    }
                    start++;
                    maxLen = Math.max(curLen, maxLen);
                }
            }
            System.out.println(curLen);
        }
        return maxLen;
    }
}
