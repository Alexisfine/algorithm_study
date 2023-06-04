package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _1926_Nearest_Exit_From_Entrance_In_Maze {
    public int nearestExit(char[][] maze, int[] entrance) {
        HashSet<int[]> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        int[] start = new int[]{entrance[0], entrance[1], 0};
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            int step = pos[2];

            if (row == 0 || row == maze.length - 1 || col == 0 || col == maze[0].length - 1) {
                if (row != entrance[0] && col != entrance[1]) return step;
            }

            int[] up = new int[]{row - 1, col, step + 1};
            if (row > 0 && maze[row - 1][col] == '.' && !visited.contains(up)) {
                visited.add(up);
                queue.add(up);
            }
            int[] down = new int[]{row + 1, col, step + 1};
            if (row < maze.length - 1 && maze[row + 1][col] == '.' && !visited.contains(down)) {
                visited.add(down);
                queue.add(down);
            }

            int[] left = new int[]{row, col - 1, step + 1};
            if (col > 0 && maze[row][col - 1] == '.' && !visited.contains(left)) {
                queue.add(left);
            }

            int[] right = new int[]{row, col + 1, step + 1};
            if (col < maze[0].length - 1 && maze[row][col + 1] == '.' && !visited.contains(right)) {
                queue.add(right);
            }
        }
        return -1;
    }
}
