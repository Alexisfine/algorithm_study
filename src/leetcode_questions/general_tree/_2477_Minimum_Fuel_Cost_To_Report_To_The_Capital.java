package leetcode_questions.general_tree;

import java.util.*;

public class _2477_Minimum_Fuel_Cost_To_Report_To_The_Capital {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    long fuel = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        for (int i = 0; i < roads.length; i++) {
            graph.putIfAbsent(roads[i][0], new ArrayList<>());
            graph.putIfAbsent(roads[i][1], new ArrayList<>());
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        dfs(-1, 0, seats);
        return fuel;
    }

    private long dfs(int prevNode, int curNode, int seats) {
        int passengers = 0;
        if (graph.containsKey(curNode)) {
            for (int nextNode : graph.get(curNode)) {
                if (nextNode != prevNode) {
                    long data = dfs(curNode, nextNode, seats);
                    passengers += data;
                    fuel += data / seats;
                    if (data % seats != 0) fuel++;
                }
            }
        }
        return passengers + 1;
    }


}
