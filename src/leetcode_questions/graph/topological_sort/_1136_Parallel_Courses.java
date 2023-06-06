package leetcode_questions.graph.topological_sort;

import java.util.*;

public class _1136_Parallel_Courses {
    public int minimumSemesters(int n, int[][] relations) {
        if (n == 0) return 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inMap = new int[n + 1];
        for (int i = 0; i < relations.length; i++) {
            graph.putIfAbsent(relations[i][0], new ArrayList<>());
            graph.get(relations[i][0]).add(relations[i][1]);
            inMap[relations[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inMap[i] == 0) queue.offer(i);
        }

        int semester = 0;
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curCourse = queue.poll();
                coursesTaken++;
                if (graph.containsKey(curCourse)) {
                    for (int nextCourse : graph.get(curCourse)) {
                        inMap[nextCourse]--;
                        if (inMap[nextCourse] == 0) queue.offer(nextCourse);
                    }
                }
            }
            semester++;
        }
        return coursesTaken == n ? semester : -1;
    }
}
