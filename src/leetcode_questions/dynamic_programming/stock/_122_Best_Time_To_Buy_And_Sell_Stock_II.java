package leetcode_questions.dynamic_programming.stock;

public class _122_Best_Time_To_Buy_And_Sell_Stock_II {
    // Time: O(N)
    // Space: O(1)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int N = prices.length;
        boolean hasBought = false;
        int profit = 0;
        int expense = 0;
        for (int i = 0; i < N - 1; i++) {
            if (!hasBought && prices[i] < prices[i + 1]) {
                hasBought = true;
                expense = prices[i];
            }
            if (hasBought && prices[i] > prices[i + 1]) {
                hasBought = false;
                profit += prices[i] - expense;
            }
        }

        if (hasBought) profit += (prices[N - 1] - expense);
        return profit;
    }
}
