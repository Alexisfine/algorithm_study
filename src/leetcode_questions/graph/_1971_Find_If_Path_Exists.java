package leetcode_questions.graph;

import java.util.*;

public class _1971_Find_If_Path_Exists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }
        }

        if (!map.containsKey(source)) return false;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < map.get(cur).size(); i++) {
                if (!visited.contains(map.get(cur).get(i))) {
                    if (map.get(cur).get(i) == destination) return true;
                    visited.add(map.get(cur).get(i));
                    queue.add(map.get(cur).get(i));
                }
            }
        }
        return false;
    }
}
