package leetcode_questions.graph.bfs;

import java.util.*;

public class _1376_Time_Needed_To_Inform_All_Employees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) return 0;

        int maxTime = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int parent = manager[i];
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int id = node[0];
            int time = node[1];
            maxTime = Math.max(maxTime, time);
            if (graph.containsKey(id)) {
                for (int next : graph.get(id)) {
                    queue.add(new int[]{next, time + informTime[id]});
                }
            }
        }
        return maxTime;
    }
}
