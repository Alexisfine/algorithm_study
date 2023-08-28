package leetcode_questions.graph.topological_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _2050_Parallel_Courses_III {
    private record Course(int number, int endTime) {}
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> leadsTo = new ArrayList<>();
        int[] inMap = new int[n];
        for (int i = 0; i < n; i++) leadsTo.add(new ArrayList<>());

        for (int[] relation : relations) {
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            inMap[nextCourse - 1]++;
            leadsTo.get(prevCourse - 1).add(nextCourse);
        }

        PriorityQueue<Course> pq = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
        for (int i = 0; i < n; i++) {
            if (inMap[i] == 0) {
                pq.offer(new Course(i + 1, time[i]));
            }
        }

        int res = 0;

        while (!pq.isEmpty()) {
            Course course = pq.poll();
            int number = course.number;
            int endTime = course.endTime;
            res = endTime;
            if (!leadsTo.get(number - 1).isEmpty()) {
                for (int nextCourse : leadsTo.get(number - 1)) {
                    inMap[nextCourse - 1]--;
                    if (inMap[nextCourse - 1] == 0) {
                        pq.offer(new Course(nextCourse, endTime + time[nextCourse - 1]));
                    }
                }
            }
        }
        return res;
    }
}
