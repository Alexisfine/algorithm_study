package leetcode_questions.graph.bfs;

import java.util.*;

public class _1306_Jump_Game_III {
    // Time: O(N)
    // Space: O(N)
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>(N);
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (arr[cur] == 0) return true;
            int left = cur - arr[cur];
            int right = cur + arr[cur];
            if (left >= 0 && left < N && !visited.contains(left)) {
                queue.offer(left);
                visited.add(left);
            }
            if (right >= 0 && right < N && !visited.contains(right)) {
                queue.offer(right);
                visited.add(right);
            }
        }
        return false;
    }
}
