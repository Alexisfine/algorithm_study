package leetcode_questions.graph;

import java.util.*;

public class _841_Keys_And_Rooms {
    public boolean canVisitedAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> zeroInQueue = new LinkedList<>();
        zeroInQueue.add(0);
        visited.add(0);
        int counter = 0;
        while (!zeroInQueue.isEmpty()) {
            int cur = zeroInQueue.poll();
            counter++;
            for (int i = 0; i < rooms.get(cur).size(); i++) {
                if (!visited.contains(rooms.get(cur).get(i))) {
                    visited.add(rooms.get(cur).get(i));
                    zeroInQueue.add(rooms.get(cur).get(i));
                }
            }
        }
        return counter == rooms.size();
    }


}
