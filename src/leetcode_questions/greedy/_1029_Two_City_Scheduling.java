package leetcode_questions.greedy;

import java.util.Arrays;

public class _1029_Two_City_Scheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int diff1 = a[0] - a[1];
            int diff2 = b[0] - b[1];
            return Math.abs(diff2) - Math.abs(diff1);
        });

        int n = costs.length / 2;
        int cityAPeople = 0;
        int cityBPeople = 0;
        int cost = 0;

        for (int i = 0; i < costs.length; i++) {
            int diff = costs[i][0] - costs[i][1];
            if (diff < 0) {
                if (cityAPeople < n) {
                    cityAPeople++;
                    cost += costs[i][0];
                } else {
                    cityBPeople++;
                    cost += costs[i][1];
                }
            } else if (diff > 0) {
                if (cityBPeople < n) {
                    cityBPeople++;
                    cost += costs[i][1];
                } else {
                    cityAPeople++;
                    cost += costs[i][0];
                }
            } else {
                if (cityAPeople <= cityBPeople) {
                    cityAPeople++;
                    cost += costs[i][0];
                } else {
                    cityBPeople++;
                    cost += costs[i][1];
                }
            }
        }
        return cost;
    }
}
