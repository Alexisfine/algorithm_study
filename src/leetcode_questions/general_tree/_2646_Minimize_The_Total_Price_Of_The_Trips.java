package leetcode_questions.general_tree;

import java.util.*;

public class _2646_Minimize_The_Total_Price_Of_The_Trips {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        if (n == 1) return price[0] / 2;
        Map<Integer, List<Integer>> graph = new HashMap<>(50);
        int[] count = new int[n];
        int[] plan0 = new int[n];
        int[] plan1 = new int[n];
        Arrays.fill(plan0, -1);
        Arrays.fill(plan1, -1);

        for (var edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (var trip : trips) {
            dfs(trip[0], -1, trip[1], graph, count);
        }

        for (int i = 0; i < n; i++) {
            price[i] *= count[i];
        }

        return DFS(0, -1, 1, graph, plan0, plan1, price);
    }

    private int DFS(int current, int parent, int flag, Map<Integer, List<Integer>> graph,
                    int[] plan0, int[] plan1, int[] price) {
        if (flag == 0) {
            if (plan0[current] != -1) return plan0[current];

            int res = price[current];
            for (var next : graph.get(current)) {
                if (next == parent) continue;
                res += DFS(next, current, 1, graph, plan0, plan1, price);
            }
            plan0[current] = res;
            return res;
        } else {
            if (plan1[current] != -1) return plan1[current];

            int option1 = price[current] / 2;
            int option2 = price[current];

            for (var next : graph.get(current)) {
                if (next == parent) continue;
                option1 += DFS(next, current, 0, graph, plan0, plan1, price);
            }

            for (var next : graph.get(current)) {
                if (next == parent) continue;
                option2 += DFS(next, current, 1, graph, plan0, plan1, price);
            }
            int res = Math.min(option1, option2);
            plan1[current] = res;
            return res;
        }
    }

    private boolean dfs(int current, int parent, int target, Map<Integer, List<Integer>> graph, int[] count) {
        if (current == target) {
            count[current]++;
            return true;
        }
        for (var next : graph.get(current)) {
            if (next == parent) continue;
            if (dfs(next, current, target, graph, count)) {
                count[current]++;
                return true;
            }
        }
        return false;
    }

    /*
    plan0[node] min gain if you cannot pick node
    plan1[node] min gain if you can pick node

    plan0[node] = val[node] + sum(plan1[child])
    plan1[node] = min(val[node]/2 + sum(plan0[child]), val[node] + sum(plan1[child]))

     */
}
