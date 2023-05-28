package leetcode_questions.dynamic_programming.stock;

import java.util.HashMap;
import java.util.Map;

public class _309_Best_Time_To_Buy_And_Sell_Stock_With_Cooldown {
    public record R(int index, boolean hasBought) {}
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        return dfs(prices, 0, false, new HashMap<>());

    }

    private static int dfs(int[] prices, int index, boolean hasBought, Map<R, Integer> cache) {
        // base case
        if (index >= prices.length) return 0;

        R r = new R(index, hasBought);
        if (cache.containsKey(r)) {
            return cache.get(r);
        }

        int max = 0;

        if (hasBought) {
            int sell = dfs(prices, index + 2, false, cache) + prices[index];
            int cooldown = dfs(prices, index + 1, true, cache);
            R res = new R(index, true);
            cache.put(res, Math.max(sell, cooldown));
            max = cache.get(res);
        } else {
            int buy = dfs(prices, index + 1, true, cache) - prices[index];
            int cooldown = dfs(prices, index + 1, false, cache);
            R res = new R(index, false);
            cache.put(res, Math.max(buy, cooldown));
            max = cache.get(res);
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int N = prices.length;
        int[][] dp = new int[N + 1][3];
        // State 0: Reset
        // State 1: Hold
        // State 2: Sold
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
                } else if (j == 1) {
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
                } else {
                    dp[i][2] = dp[i - 1][1] + prices[i - 1];
                }
            }
        }
        return Math.max(dp[N][0], dp[N][2]);
    }

    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int N = prices.length;
        // State 0: Reset
        // State 1: Hold
        // State 2: Sold
        int reset = 0;
        int hold = Integer.MIN_VALUE;
        int sold = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            int preHold = hold;
            hold = Math.max(hold, reset - prices[i]);
            reset = Math.max(reset, sold + prices[i]);
            sold = preHold;
        }
        return Math.max(sold, reset);
    }
}
