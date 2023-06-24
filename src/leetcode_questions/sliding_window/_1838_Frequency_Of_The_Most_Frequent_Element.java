package leetcode_questions.sliding_window;

import java.util.Arrays;

public class _1838_Frequency_Of_The_Most_Frequent_Element {
    public int maxFrequency(int[] nums, int k) {
        int res = 1;
        int moves = 0;
        Arrays.sort(nums);
        int start = 0;
        for (int end = 1; end < nums.length; end++) {
            moves += (end - start) * (nums[end] - nums[end - 1]);
            while (moves > k) {
                moves -= nums[end] - nums[start];
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
