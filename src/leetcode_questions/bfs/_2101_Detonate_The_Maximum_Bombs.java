package leetcode_questions.bfs;

import java.util.*;

public class _2101_Detonate_The_Maximum_Bombs {

    public int maximumDetonation(int[][] bombs) {
        int N = bombs.length;

        List<List<Integer>> next = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            next.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                long dx = Math.abs(bombs[i][0] - bombs[j][0]);
                long dy = Math.abs(bombs[i][1] - bombs[j][1]);
                long r = bombs[i][2];
                if (dx * dx + dy * dy <= r * r) {
                    next.get(i).add(j);
                }
            }
        }

        int explodedBombs = 0;

        for (int start = 0; start < N; start++) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.offer(start);
            visited.add(start);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (!next.get(cur).isEmpty()) {
                    for (int nextBomb : next.get(cur)) {
                        if (!visited.contains(nextBomb)) {
                            queue.offer(nextBomb);
                            visited.add(nextBomb);
                        }
                    }
                }
            }
            explodedBombs = Math.max(explodedBombs, visited.size());
        }
        return explodedBombs;
    }
}
