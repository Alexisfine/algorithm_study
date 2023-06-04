package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1162_As_Far_From_Land_As_Possible {
    public int maxDistance(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int count = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> pair = List.of(i, j);
                    queue.add(pair);
                    visited.add(pair);
                    count++;
                }
            }
        }

        if (queue.size() == M * N) return -1;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> position = queue.poll();
                int row = position.get(0);
                int col = position.get(1);

                List<Integer> up = List.of(row - 1, col);
                if (row > 0 && !visited.contains(up)) {
                    visited.add(up);
                    queue.add(up);
                    count++;
                }

                List<Integer> down = List.of(row, col - 1);
                if (col > 0 && !visited.contains(down)) {
                    visited.add(down);
                    queue.add(down);
                    count++;
                }

                List<Integer> left = List.of(row + 1, col);
                if (row < M - 1 && !visited.contains(left)) {
                    visited.add(left);
                    queue.add(left);
                    count++;
                }

                List<Integer> right = List.of(row, col + 1);
                if (col < N - 1 && !visited.contains(right)) {
                    visited.add(right);
                    queue.add(right);
                    count++;
                }
            }
            distance++;
        }
        return distance - 1;
    }
}
