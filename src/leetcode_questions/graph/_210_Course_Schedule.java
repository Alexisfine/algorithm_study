package leetcode_questions.graph;

import java.util.*;

public class _210_Course_Schedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inMap = new int[numCourses];
        Map<Integer, List<Integer>> leadsTo = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inMap[prerequisites[i][0]]++;
            if (leadsTo.containsKey(prerequisites[i][1])) {
                leadsTo.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>(numCourses);
                list.add(prerequisites[i][0]);
                leadsTo.put(prerequisites[i][1], list);
            }
        }

        Queue<Integer> zeroInQueue = new LinkedList<>();
        for (int i = 0; i < inMap.length; i++) {
            if (inMap[i] == 0) zeroInQueue.add(i);
        }

        int[] order = new int[numCourses];

        int counter = 0;
        while (!zeroInQueue.isEmpty()) {
            int cur = zeroInQueue.poll();
            order[counter++] = cur;
            if (!leadsTo.containsKey(cur)) continue;
            for (int next : leadsTo.get(cur)) {
                inMap[next]--;
                if (inMap[next] == 0) zeroInQueue.add(next);
            }
        }
        return counter == numCourses ? order : new int[0];
    }
}
