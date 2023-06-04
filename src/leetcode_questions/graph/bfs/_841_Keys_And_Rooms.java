package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841_Keys_And_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        int totalVisited = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            totalVisited++;
            for (int next : rooms.get(room)) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return N == totalVisited;
    }
}
