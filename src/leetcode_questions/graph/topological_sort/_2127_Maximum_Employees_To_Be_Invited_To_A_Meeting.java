package leetcode_questions.graph.topological_sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _2127_Maximum_Employees_To_Be_Invited_To_A_Meeting {
    public int maximumInvitations(int[] favorite) {
        int N = favorite.length;
        int[] inMap = new int[N];
        int[] depth = new int[N];
        for (int i = 0; i < N; i++) {
            inMap[favorite[i]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        Arrays.fill(depth, 1);
        for (int i = 0; i < N; i++) {
            if (inMap[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int next = favorite[cur];
            inMap[next]--;
            if (inMap[next] == 0) {
                queue.offer(next);
                visited[next] = true;
            }
            depth[next] = depth[cur] + 1;
        }

        int maxMultiNodeCircle = 0;
        int maxLink = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            int j = i;
            int count = 0;
            while (!visited[j]) {
                count++;
                visited[j] = true;
                j = favorite[j];
            }
            if (count >= 3) {
                maxMultiNodeCircle = Math.max(maxMultiNodeCircle, count);
            } else if (count == 2) {
                maxLink += depth[i] + depth[favorite[i]];
            }
        }

        return Math.max(maxMultiNodeCircle, maxLink);
    }
}
