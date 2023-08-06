package leetcode_questions.companies.amazon;


import java.util.Stack;

public class _2355_Maximum_Number_Of_Books_You_Can_Take {
    public long maximumBooks(int[] books) {
         int N = books.length;
         long[] dp = new long[N];
         Stack<Integer> stack = new Stack<>();

         long res = 0;

         for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && books[stack.peek()] > books[i] - (i - stack.peek())) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int j = stack.peek();
                int l = i - j;
                dp[i] = dp[j] + ((long) books[i] + books[i] - l + 1) * l / 2;
            } else {
                int l = Math.min(i + 1, books[i]);
                dp[i] = ((long) books[i] + books[i] - l + 1) * l / 2;
            }
            res = Math.max(res, dp[i]);
            stack.push(i);
         }
         return res;
    }

    /**
     * dp[i]: max books taken from books[0:i]
     * dp[i] = dp[j] + sum of an arithmetic sequence
     * L = i - j
     * sum = (books[i] + books[i - L + 1]) * L / 2
     */
}
