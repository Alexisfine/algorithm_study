package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProjectProfit {
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

    public static int findMaxProfit(int k, int w, Project[] projects) {
        PriorityQueue<Project> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Project> maxProfit = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < projects.length; i++) minCost.add(projects[i]);
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().cost <= w) maxProfit.add(minCost.poll());
            if (maxProfit.isEmpty()) return w;
            w += maxProfit.poll().profit;
        }
        return w;
    }

}
