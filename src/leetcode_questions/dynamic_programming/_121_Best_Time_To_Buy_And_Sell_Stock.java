package leetcode_questions.dynamic_programming;

import java.util.Arrays;

public class _121_Best_Time_To_Buy_And_Sell_Stock {
    // Time: O(n)
    // Space: O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) min = prices[i];
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

}
