package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _286_Walls_And_Gates {
    public void wallsAndGates(int[][] rooms) {
        int M = rooms.length;
        int N = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int row = pos[0];
                int col = pos[1];
                int distance = pos[2];
                rooms[row][col] = Math.min(rooms[row][col], distance);

                if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                    queue.add(new int[]{row - 1, col, distance + 1});
                }

                if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                    queue.add(new int[]{row, col - 1, distance + 1});
                }

                if (row < M - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                    queue.add(new int[]{row + 1, col, distance + 1});
                }

                if (col < N - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                    queue.add(new int[]{row, col + 1, distance + 1});
                }
            }
        }
    }


}
