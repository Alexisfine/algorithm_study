package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _505_The_Maze_II {
    // Time: O(MN * logMN)
    // Space: O(MN)
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int M = maze.length;
        int N = maze[0].length;

        int[][] distance = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;

        Set<List<Integer>> visited = new HashSet<>();
        // {row, col, dist}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{start[0], start[1], 0});

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curPos = pq.poll();
            int curRow = curPos[0];
            int curCol = curPos[1];
            int curDistance = curPos[2];
            List<Integer> list = List.of(curRow, curCol);
            if (visited.contains(list)) continue;
            visited.add(list);
            distance[curRow][curCol] = curDistance;
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
                    pq.offer(new int[]{nextRow, nextCol, curDistance + delta});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 : distance[destination[0]][destination[1]];
    }
}
