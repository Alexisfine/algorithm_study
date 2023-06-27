package leetcode_questions.companies.amazon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _2355_Maximum_Number_Of_Books_You_Can_Take {
    // Time: O(N^2)
    public long maximumBooks1(int[] books) {
        long total = 0;
        long res = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int cur = 0; cur < books.length; cur++) {
            if (deque.isEmpty() || deque.getLast() < books[cur]) {
                total += books[cur];
                deque.addLast(books[cur]);
                res = Math.max(res, total);
            } else {
                int size = Math.min(books[cur] - 1, deque.size());
                while (!deque.isEmpty() && deque.size() > size) {
                    total -= deque.removeFirst();
                }
                int i = 1;
                int prevSize = deque.size();
                while (!deque.isEmpty() && deque.getLast() >= books[cur] - i) {
                    total -= deque.removeLast();
                    i++;
                }
                prevSize = prevSize - deque.size();
                for (int j = 0; j < prevSize; j++) {
                    deque.addLast(books[cur] - prevSize + j);
                    total += books[cur] - prevSize + j;
                }
                deque.addLast(books[cur]);
                total += books[cur];
                res = Math.max(res, total);
            }
        }
        return res;
    }

    public long maximumBooks2(int[] books) {
        return 0;
    }
}
