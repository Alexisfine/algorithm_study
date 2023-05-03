package leetcode_questions.graph;

import java.util.*;

public class _1462_Course_Schedule {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        int[] inMap = new int[numCourses];
        Map<Integer, List<Integer>> leadsTo = new HashMap<>();
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inMap[prerequisites[i][0]]++;
            if (!leadsTo.containsKey(prerequisites[i][1])) {
                leadsTo.put(prerequisites[i][1], new ArrayList<>());
            }
            leadsTo.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inMap.length; i++) {
            if (inMap[i] == 0) {
                Set<Integer> prereq = new HashSet<>();
                prereqMap.put(i, prereq);
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!leadsTo.containsKey(cur)) continue;
            for (int next : leadsTo.get(cur)) {
                if (!prereqMap.containsKey(next)) {
                    prereqMap.put(next, new HashSet<>());
                }
                prereqMap.get(next).addAll(prereqMap.get(cur));
                prereqMap.get(next).add(cur);
                inMap[next]--;
                if (inMap[next] == 0) {
                    queue.add(next);
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (!prereqMap.containsKey(queries[i][0])) {
                result.add(false);
                continue;
            }
            result.add(prereqMap.get(queries[i][0]).contains(queries[i][1]));
        }
        return result;
    }
}
