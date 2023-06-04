package leetcode_questions.graph;

import java.util.*;

public class _207_Course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int coursesTaken = 0;
        int[] inMap = new int[numCourses];
        Map<Integer, List<Integer>> leadsTo = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inMap[prerequisites[i][0]]++;
            if (leadsTo.containsKey(prerequisites[i][1])) {
                leadsTo.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> courses = new ArrayList<>();
                courses.add(prerequisites[i][0]);
                leadsTo.put(prerequisites[i][1], courses);
            }
        }

        Queue<Integer> zeroInQueue = new LinkedList<>();
        for (int i = 0; i < inMap.length; i++) {
            if (inMap[i] == 0) zeroInQueue.add(i);
        }

        while (!zeroInQueue.isEmpty()) {
            int cur = zeroInQueue.poll();
            coursesTaken++;
            if (!leadsTo.containsKey(cur)) continue;
            for (int next : leadsTo.get(cur)) {
                inMap[next]--;
                if (inMap[next] == 0) zeroInQueue.add(next);
            }
        }

        return coursesTaken == numCourses;
    }
}
