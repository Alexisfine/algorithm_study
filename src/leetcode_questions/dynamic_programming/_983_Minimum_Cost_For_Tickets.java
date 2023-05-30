package leetcode_questions.dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _983_Minimum_Cost_For_Tickets {

    // Time: O(W)
    // Space: O(W)
    // W = 365
    public static int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        int[] cache = new int[365 + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        for (int i = 0; i < days.length; i++) daySet.add(days[i]);
        return dp(days, costs, daySet, cache, 0);
    }

    private static int dp(int[] days, int[] costs, Set<Integer> daySet, int[] cache, int index) {
        if (index > 365) return 0;
        if (cache[index] != Integer.MAX_VALUE) return cache[index];

        if (daySet.contains(index)) {
            int one = dp(days, costs, daySet, cache, index + 1) + costs[0];
            int seven = dp(days, costs, daySet, cache, index + 7) + costs[1];
            int thirty = dp(days, costs, daySet, cache, index + 30) + costs[2];
            int min = Math.min(one, Math.min(seven, thirty));
            cache[index] = min;
            return cache[index];
        } else {
            int min = dp(days, costs, daySet, cache, index + 1);
            cache[index] = min;
            return cache[index];
        }
    }

    public static int mincostTickets2(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int i = 0; i < days.length; i++) daySet.add(days[i]);

        int[] dp = new int[367];
        for (int i = 365; i > 0; i--) {
            if (daySet.contains(i)) {
                int one = costs[0];
                if (i + 1 <= 365) one += dp[i + 1];
                int seven = costs[1];
                if (i + 7 <= 365) seven += dp[i + 7];
                int thirty = costs[2];
                if (i + 30 <= 365) thirty += dp[i + 30];
                dp[i] = Math.min(one, Math.min(seven, thirty));
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[1];
    }

    public static int mincostTickets3(int[] days, int[] costs) {
        int N = days.length;
        int[] dp = new int[N];
        int[] durations = new int[]{1, 7, 30};

        for (int i = N - 1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            int j = i;
            for (int k = 0; k < 3; k++) {
                while (j < N && days[j] < days[i] + durations[k]) {
                    j++;
                }
                ans = Math.min(dp[i], costs[k] + dp[j]);
            }
            dp[i] = ans;
        }
        return dp[0];

    }




}
