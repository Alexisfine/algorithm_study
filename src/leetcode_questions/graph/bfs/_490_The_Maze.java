package leetcode_questions.graph.bfs;

import java.util.*;

public class _490_The_Maze {
    // Time: O(M * N)
    // Space: O(M * N)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int M = maze.length;
        int N = maze[0].length;
        Set<List<Integer>> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(List.of(start[0], start[1]));

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                int curRow = curPos[0];
                int curCol = curPos[1];
                if (curRow == destination[0] && curCol == destination[1]) return true;

                for (int[] direction : directions) {
                    int delta = 1;
                    while (true) {
                        int nextRow = curRow + delta * direction[0];
                        int nextCol = curCol + delta * direction[1];
                        if (nextRow < 0 || nextCol < 0 || nextRow == M || nextCol == N) break;
                        if (maze[nextRow][nextCol] == 0) {
                            delta++;
                        } else break;
                    }
                    delta--;
                    int nextRow = curRow + delta * direction[0];
                    int nextCol = curCol + delta * direction[1];
                    List<Integer> nextPos = List.of(nextRow, nextCol);
                    if (!visited.contains(nextPos)) {
                        visited.add(nextPos);
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        return false;
    }

}
