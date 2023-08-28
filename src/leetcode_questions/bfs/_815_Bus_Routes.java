package leetcode_questions.bfs;

import java.util.*;

public class _815_Bus_Routes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int bus = 0;
        for (int[] route : routes) {
            for (int station : route) {
                graph.putIfAbsent(station, new ArrayList<>());
                graph.get(station).add(bus);
            }
            bus++;
        }

        if (!graph.containsKey(source) || !graph.containsKey(target)) return -1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        for (int curBus : graph.get(source)) {
            queue.offer(curBus);
        }

        int buses = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curBus = queue.poll();
                for (int j = 0; j < routes[curBus].length; j++) {
                    int station = routes[curBus][j];
                    if (station == target) return buses;
                    if (!visited.contains(station)) {
                        visited.add(station);
                        for (int nextBus : graph.get(station)) {
                            if (nextBus != curBus) {
                                queue.offer(nextBus);
                            }
                        }
                    }
                }
            }
            buses++;
        }
        return -1;
    }
}
