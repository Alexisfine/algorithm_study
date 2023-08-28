package leetcode_questions.greedy.regret_greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _630_Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // sort courses based on deadline
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // sort based on course length

        int days = 0;
        for (int i = 0; i < courses.length; i++) {
            pq.offer(courses[i][0]);
            days += courses[i][0];
            if (days > courses[i][1]) {
                days -= pq.poll();
            }
        }
        return pq.size();
    }

    /*
    Sort + PQ
    每加一门课，
    if 加上课也没问题：加上
    else 优化已经选择的课程（根据课程时间）
     */
}
