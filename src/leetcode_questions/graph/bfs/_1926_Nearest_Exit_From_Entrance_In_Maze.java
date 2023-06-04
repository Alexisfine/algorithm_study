package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1926_Nearest_Exit_From_Entrance_In_Maze {
    // Time: O(M * N)
    // Space: O(M * N)
    public int nearestExit(char[][] maze, int[] entrance) {
        int M = maze.length;
        int N = maze[0].length;
        HashSet<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(entrance[0], entrance[1], 0));
        visited.add(List.of(entrance[0], entrance[1]));


        while (!queue.isEmpty()) {
            List<Integer> pos = queue.poll();
            int row = pos.get(0);
            int col = pos.get(1);
            int step = pos.get(2);
            if (step != 0 && (row == 0 || col == 0 || row == M - 1 || col == N - 1)) return step;

            if (row > 0 && maze[row - 1][col] == '.' && !visited.contains(List.of(row - 1, col))) {
                queue.add(List.of(row - 1, col, step + 1));
                visited.add(List.of(row - 1, col));
            }

            if (col > 0 && maze[row][col - 1] == '.' && !visited.contains(List.of(row, col - 1))) {
                queue.add(List.of(row, col - 1, step + 1));
                visited.add(List.of(row, col - 1));
            }

            if (row < M - 1 && maze[row + 1][col] == '.' && !visited.contains(List.of(row + 1, col))) {
                queue.add(List.of(row + 1, col, step + 1));
                visited.add(List.of(row + 1, col));
            }

            if (col < N - 1 && maze[row][col + 1] == '.' && !visited.contains(List.of(row, col + 1))) {
                queue.add(List.of(row, col + 1, step + 1));
                visited.add(List.of(row, col + 1));
            }
        }
        return -1;
    }
}
