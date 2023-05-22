package dynamic_programming;

public class ZhuBo {
    public static int minCost(int addCost, int timeCost, int subCost, int start, int goal) {
        if (start > goal) return -1;
        return process(0, goal, addCost, timeCost, subCost,
                start, goal * 2, ((goal - start) / 2 * addCost));
    }

    public static int process(int currentCost, int goal, int addCost, int timeCost, int subCost,
                              int current, int limitAim, int limitCost) {
        if (currentCost > limitCost) return Integer.MAX_VALUE;
        if (current < 0) return Integer.MAX_VALUE;
        if (current > limitAim) return Integer.MAX_VALUE;
        if (current == goal) return currentCost;

        int min = Integer.MAX_VALUE;

        int p1 = process(currentCost + addCost, goal, addCost, timeCost, subCost,
                current + 2, limitAim, limitCost);
        if (p1 != Integer.MAX_VALUE) min = p1;

        int p2 = process(currentCost + timeCost, goal, addCost, timeCost, subCost,
                current * 2, limitAim, limitCost);
        if (p2 != Integer.MAX_VALUE) min = Math.min(min, p2);

        int p3 = process(currentCost + subCost, goal, addCost, timeCost, subCost,
                current - 2, limitAim, limitCost);
        if (p3 != Integer.MAX_VALUE) min = Math.min(min, p3);

        return min;
    }

    public static int process2(int addCost, int timeCost, int subCost, int start, int goal) {
        if (start > goal) return -1;
        int limitCoin = ((goal - start) / 2) * addCost;
        int limitAim = goal * 2;

        int[][] dp = new int[limitCoin + 1][limitAim + 1];
        for (int currentCost = 0; currentCost <= limitCoin; currentCost++) {
            for (int aim = 0; aim <= limitAim; aim++) {
                if (aim == start) dp[currentCost][aim] = currentCost;
                else dp[currentCost][aim] = Integer.MAX_VALUE;
            }
        }

        for (int currentCost = limitCoin; currentCost >= 0; currentCost--) {
            for (int aim = 0; aim <= limitAim; aim++) {
                if (aim - 2 >= 0 && currentCost + addCost <= limitCoin) {
                    dp[currentCost][aim] = Math.min(dp[currentCost][aim], dp[currentCost + addCost][aim - 2]);
                }
                if (aim + 2 <= limitAim && currentCost + subCost <= limitCoin) {
                    dp[currentCost][aim] = Math.min(dp[currentCost][aim], dp[currentCost + subCost][aim + 2]);
                }
                if ((aim & 1) == 0) {
                    if (aim / 2 >= 0 && currentCost + timeCost <= limitCoin) {
                        dp[currentCost][aim] = Math.min(dp[currentCost][aim], dp[currentCost + timeCost][aim / 2]);
                    }
                }
            }
        }
        return dp[0][goal];

    }
}
