package leetcode_questions.deque;

import java.util.Deque;
import java.util.LinkedList;

public class _239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) return null;
        Deque<Integer> sw = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        // add k values
        for (int i = 0; i < k; i++) {
            while (!sw.isEmpty() && sw.getLast() < nums[i]) sw.removeLast();
            sw.addLast(nums[i]);
        }

        int leftPtr = 0;
        int rightPtr = k;
        res[0] = sw.getFirst();
        for (int i = 1; i < res.length; i++) {
            // move left slider
            if (sw.getFirst() == nums[leftPtr++]) sw.removeFirst();

            // move right slider
            while (!sw.isEmpty() && sw.getLast() < nums[rightPtr]) sw.removeLast();
            sw.addLast(nums[rightPtr++]);
            res[i] = sw.getFirst();
        }
        return res;
    }
}
