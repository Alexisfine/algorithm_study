package leetcode_questions.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _542_01_Matrix {
    public record Coordinate(int row, int col) {}

    // Time: O(M * N)
    // Space: O(M * N)
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        Queue<Coordinate> queue = new LinkedList<>();
        HashSet<Coordinate> visited = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    Coordinate position = new Coordinate(i, j);
                    queue.offer(position);
                    visited.add(position);
                }
            }
        }

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = queue.poll();
                mat[cur.row][cur.col] = distance;

                Coordinate up = new Coordinate(cur.row - 1, cur.col);
                Coordinate down = new Coordinate(cur.row + 1, cur.col);
                Coordinate left = new Coordinate(cur.row, cur.col - 1);
                Coordinate right = new Coordinate(cur.row, cur.col + 1);

                if (cur.row > 0 && !visited.contains(up)) {
                    visited.add(up);
                    queue.offer(up);
                }

                if (cur.row < M - 1 && !visited.contains(down)) {
                    visited.add(down);
                    queue.offer(down);
                }

                if (cur.col > 0 && !visited.contains(left)) {
                    visited.add(left);
                    queue.offer(left);
                }

                if (cur.col < N - 1 && !visited.contains(right)) {
                    visited.add(right);
                    queue.offer(right);
                }
            }
            distance++;
        }
        return mat;
    }
}
