package leetcode_questions.sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class _2762_Continuous_Subarrays {
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        int N = nums.length;
        Deque<Integer> maxDeq = new LinkedList<>();
        Deque<Integer> minDeq = new LinkedList<>();
        int i = 0;
        for (int j = 0; j < N; j++) {
            while (!maxDeq.isEmpty() && nums[maxDeq.getLast()] < nums[j]) maxDeq.removeLast();
            maxDeq.addLast(j);

            while (!minDeq.isEmpty() && nums[minDeq.getLast()] > nums[j]) minDeq.removeLast();
            minDeq.addLast(j);

            while (nums[maxDeq.getFirst()] - nums[minDeq.getFirst()] > 2) {
                while (!maxDeq.isEmpty() && maxDeq.getFirst() <= i) maxDeq.removeFirst();
                while (!minDeq.isEmpty() && minDeq.getFirst() <= i) maxDeq.removeFirst();
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
