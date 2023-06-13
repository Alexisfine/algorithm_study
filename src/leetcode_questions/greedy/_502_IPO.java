package leetcode_questions.greedy;


import java.util.Comparator;
import java.util.PriorityQueue;

public class _502_IPO {
    // Time: O(NlogN)
    // Space: O(N)
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minCost = new PriorityQueue<>(new MinCostComparator());
        for (int i = 0; i < profits.length; i++) minCost.add(new Project(capital[i], profits[i]));

        PriorityQueue<Project> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().cost <= w) maxProfit.add(minCost.poll());
            if (maxProfit.isEmpty()) return w;
            w += maxProfit.poll().profit;
        }
        return w;
    }

    private static class Project {
        int cost;
        int profit;
        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class MinCostComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class MaxProfitComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit - o1.profit;
        }
    }


}
