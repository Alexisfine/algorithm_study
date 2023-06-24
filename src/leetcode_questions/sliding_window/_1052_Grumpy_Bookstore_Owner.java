package leetcode_questions.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1052_Grumpy_Bookstore_Owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxIncrement = 0;
        int maxIncrementIndex = 0;
        int total = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < minutes; i++) {
            int increment = grumpy[i] == 1 ? customers[i] : 0;
            deque.addFirst(increment);
            total += increment;
            maxIncrement = Math.max(maxIncrement, total);
        }

        for (int end = minutes; end < customers.length; end++) {
            total -= deque.removeLast();
            int increment = grumpy[end] == 1 ? customers[end] : 0;
            deque.addFirst(increment);
            total += increment;
            if (maxIncrement < total) {
                maxIncrement = total;
                maxIncrementIndex = end - minutes + 1;
            }
        }

        int index = 0;
        int res = 0;
        while (index < customers.length) {
            if (index == maxIncrementIndex) {
                while (index < maxIncrementIndex + minutes) {
                    res += customers[index];
                    index++;
                }
            } else {
                res += grumpy[index] == 1 ? 0 : customers[index];
                index++;
            }
        }
        return res;
    }
}
