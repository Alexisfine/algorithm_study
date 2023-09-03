package leetcode_questions.deque;

import java.util.Deque;
import java.util.LinkedList;

public class _1499_Max_Value_Of_Equation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int N = points.length;
        Deque<Integer> deque = new LinkedList<>();
        int left = 0;
        int res = Integer.MIN_VALUE;
        for (int right = 0; right < N; right++) {
            while (points[right][0] - points[left][0] > k) left++;
            while (!deque.isEmpty() && deque.getFirst() < left) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
               res = Math.max(res,
                       points[deque.getFirst()][1] - points[deque.getFirst()][0] +
                       points[right][1] + points[right][0]);
            }
            while (!deque.isEmpty() && points[deque.getLast()][1] - points[deque.getLast()][0] <=
                    points[right][1] - points[right][0]) {
                deque.removeLast();
            }
            deque.addLast(right);
        }
        return res;
    }
}
