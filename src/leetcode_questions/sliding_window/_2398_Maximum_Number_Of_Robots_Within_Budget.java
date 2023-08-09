package leetcode_questions.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2398_Maximum_Number_Of_Robots_Within_Budget {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0;
        int right = chargeTimes.length;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (isOK(mid, chargeTimes, runningCosts, budget)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isOK(int len, int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> deque = new ArrayDeque<>();
        long sum = 0;

        for (int i = 0; i < chargeTimes.length; i++) {
            sum += runningCosts[i];
            while (!deque.isEmpty() && chargeTimes[deque.getLast()] <= chargeTimes[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty() && deque.getFirst() <= i - len) {
                deque.removeFirst();
            }
            if (i >= len - 1) {
                long cost = chargeTimes[deque.getFirst()] + len * sum;
                if (cost <= budget) {
                    return true;
                }
                sum -= runningCosts[i - len + 1];
            }
        }
        return false;
    }
}
