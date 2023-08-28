package leetcode_questions.greedy.sort_plus_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1834_Single_Threaded_CPU {
    public record Pair(int enqueueTime, int processTime, int index) {}
    public int[] getOrder(int[][] tasks) {
        int N = tasks.length;
        Pair[] order = new Pair[N];
        for (int i = 0; i < N; i++) {
            order[i] = new Pair(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(order, (a, b) -> {
            if (a.enqueueTime != b.enqueueTime) return a.enqueueTime - b.enqueueTime;
            if (a.processTime != b.processTime) return a.processTime - b.processTime;
            return a.index - b.index;
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.processTime != b.processTime) return a.processTime - b.processTime;
            return a.index - b.index;
        });

        int[] res = new int[N];
        int availableTime = 0;
        int tasksProcessed = 0;
        for (int i = 0; i < N; i++) {
            int enqueueTime = order[i].enqueueTime;

            while (availableTime < enqueueTime && !pq.isEmpty()) {
                Pair nextTask = pq.peek();
                res[tasksProcessed++] = nextTask.index;
                availableTime += nextTask.processTime;
                pq.poll();
            }

            pq.offer(order[i]);
            if (availableTime <= enqueueTime) {
                Pair nextTask = pq.peek();
                res[tasksProcessed++] = nextTask.index;
                availableTime = enqueueTime + nextTask.processTime;
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res[tasksProcessed++] = pq.poll().index;
        }
        return res;
    }
}
