package leetcode_questions.greedy;

import java.util.*;

public class _621_Task_Scheduler {
    private record Cooldown(char letter, int times, int lockedTime) {};
    private record Pair(char letter, int times) {};
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            countMap.put(tasks[i], countMap.getOrDefault(tasks[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.times - a.times);

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int time = 0;
        int completedTasks = 0;
        Queue<Cooldown> queue = new LinkedList<>();
        while (!pq.isEmpty() || completedTasks < tasks.length) {
            if (!pq.isEmpty()) {
                Pair task = pq.poll();
                int remainingCount = task.times - 1;

                if (remainingCount > 0) {
                    queue.offer(new Cooldown(task.letter, task.times - 1, time));
                }
                completedTasks++;
            }

            if (!queue.isEmpty() && queue.peek().lockedTime + n == time) {
                Cooldown task = queue.poll();
                pq.offer(new Pair(task.letter, task.times));
            }
            time++;
        }
        return time;
    }


}
