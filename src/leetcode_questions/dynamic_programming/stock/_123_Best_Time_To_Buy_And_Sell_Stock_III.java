package leetcode_questions.dynamic_programming.stock;

import java.util.PriorityQueue;

public class _123_Best_Time_To_Buy_And_Sell_Stock_III {
    // Time: O(N)
    // Space: O(N)
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int N = prices.length;

        int[] left = new int[N];
        int min = prices[0];
        for (int i = 1; i < N; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int[] right = new int[N];
        int max = prices[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int profit = Math.max(left[N - 1], right[0]);
        for (int i = 1; i < N - 2; i++) {
            profit = Math.max(profit, left[i] + right[i + 1]);
        }
        return profit;
    }

    // Time: O(N)
    // Space: O(1)
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int N = prices.length;

        int b1 = Integer.MAX_VALUE;
        int b2 = Integer.MAX_VALUE;
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < N; i++) {
            b1 = Math.min(b1, prices[i]);
            s1 = Math.max(s1, prices[i] - b1);

            b2 = Math.min(b2, prices[i] - s1);
            s2 = Math.max(s2, prices[i] - b2);
        }
        return s2;
    }
}
