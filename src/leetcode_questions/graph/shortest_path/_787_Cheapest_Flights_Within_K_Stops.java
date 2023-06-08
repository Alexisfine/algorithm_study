package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _787_Cheapest_Flights_Within_K_Stops {
    // Time: O(N * K)
    // Space: O(N)
    // Bellman ford algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            int[] temp = Arrays.copyOf(prices, prices.length);
            for (int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int cost = flights[j][2];
                if (prices[from] == Integer.MAX_VALUE) continue;
                temp[to] = Math.min(temp[to], prices[from] + cost);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
