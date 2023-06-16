package leetcode_questions.graph.bfs;

import java.util.*;

public class _1345_Jump_Game_IV {
    public int minJumps(int[] arr) {
        int N = arr.length;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            graph.putIfAbsent(arr[i], new ArrayList<>());
            graph.get(arr[i]).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);

        int jump = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();
                if (curPos == N - 1) return jump;
                for (int nextPos : graph.get(arr[curPos])) {
                    if (!visited.contains(nextPos)) {
                        queue.offer(nextPos);
                        visited.add(nextPos);
                    }
                }
                graph.get(arr[curPos]).clear();
                if (curPos > 0 && !visited.contains(curPos - 1)) {
                    queue.offer(curPos - 1);
                    visited.add(curPos - 1);
                }
                if (curPos < N - 1 && !visited.contains(curPos + 1)) {
                    queue.offer(curPos + 1);
                    visited.add(curPos + 1);
                }
            }
            jump++;
        }
        return jump;
    }
}
