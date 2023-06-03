package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1091_Shortest_Path_In_Binary_Matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == -1) return -1;

        int N = grid.length;
        Queue<List<Integer>> queue = new LinkedList<>();
        HashSet<List<Integer>> visited = new HashSet<>();
        queue.add(List.of(0, 0, 1));
        visited.add(List.of(0, 0));

        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int r = list.get(0);
            int c = list.get(1);
            int distance = list.get(2);
            if (Math.min(r, c) < 0 || Math.max(r, c) >= N || grid[r][c] == 1) continue;
            if (r == N - 1 && c == N - 1) return distance;


            if (!visited.contains(List.of(r + 1, c))) {
                queue.add(List.of(r + 1, c, distance + 1));
                visited.add(List.of(r + 1, c));
            }

            if (!visited.contains(List.of(r - 1, c))) {
                queue.add(List.of(r - 1, c, distance + 1));
                visited.add(List.of(r - 1, c));
            }

            if (!visited.contains(List.of(r, c + 1))) {
                queue.add(List.of(r, c + 1, distance + 1));
                visited.add(List.of(r, c));
            }

            if (!visited.contains(List.of(r, c - 1))) {
                queue.add(List.of(r, c - 1, distance + 1));
                visited.add(List.of(r, c - 1));
            }

            if (!visited.contains(List.of(r + 1, c + 1))) {
                queue.add(List.of(r + 1, c + 1, distance + 1));
                visited.add(List.of(r + 1, c + 1));
            }

            if (!visited.contains(List.of(r + 1, c - 1))) {
                queue.add(List.of(r + 1, c - 1, distance + 1));
                visited.add(List.of(r + 1, c));
            }

            if (!visited.contains(List.of(r - 1, c + 1))) {
                queue.add(List.of(r - 1, c + 1, distance + 1));
                visited.add(List.of(r - 1, c + 1));
            }

            if (!visited.contains(List.of(r - 1, c - 1))) {
                queue.add(List.of(r - 1, c - 1, distance + 1));
                visited.add(List.of(r - 1, c - 1));
            }

        }
        return -1;
    }
}
