package leetcode_questions.bfs.multistate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1293_Shortest_Path_In_A_Grid_With_Obstacles_Elimination {
    private record Info(int x, int y, int k) {}
    public int shortestPath(int[][] grid, int k) {
        int M = grid.length;
        int N = grid[0].length;
        if (grid[0][0] == 1) return -1;
        if (M == 1 && N == 1) return 0;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Info> queue = new LinkedList<>();
        int[][] visited = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        queue.offer(new Info(0, 0, k));
        visited[0][0] = k;

        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Info cur = queue.poll();
                for (int[] direction : directions) {
                    int nextX = cur.x + direction[0];
                    int nextY = cur.y + direction[1];
                    int nextK = cur.k;
                    if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
                    if (visited[nextX][nextY] == -1) {
                        if (grid[nextX][nextY] == 1) nextK--;
                        if (nextK < 0) continue;
                        queue.offer(new Info(nextX, nextY, nextK));
                        visited[nextX][nextY] = nextK;
                        if (nextX == M - 1 && nextY == N - 1) return step + 1;
                    } else {
                        if (grid[nextX][nextY] == 1) nextK--;
                        if (nextK < 0) continue;
                        if (visited[nextX][nextY] < nextK) {
                            queue.offer(new Info(nextX, nextY, nextK));
                            visited[nextX][nextY] = nextK;
                        }
                        if (nextX == M - 1 && nextY == N - 1) return step + 1;
                    }
                }
            }
        }
        return -1;
    }
}
