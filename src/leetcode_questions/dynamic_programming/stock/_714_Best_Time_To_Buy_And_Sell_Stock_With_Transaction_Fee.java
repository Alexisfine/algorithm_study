package leetcode_questions.dynamic_programming.stock;

public class _714_Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee {
    // Time: O(N)
    // Space: O(1)
    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;

        int N = prices.length;
        int hasBought = Integer.MIN_VALUE;
        int hasNotBought = 0;
        for (int i = 0; i < N; i++) {
            int temp = hasBought;
            hasBought = Math.max(hasBought, hasNotBought - prices[i] - fee);
            hasNotBought = Math.max(hasNotBought, temp + prices[i]);
        }
        return hasNotBought;
    }
}
