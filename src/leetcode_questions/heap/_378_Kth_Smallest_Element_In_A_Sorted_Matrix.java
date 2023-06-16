package leetcode_questions.heap;

import java.util.PriorityQueue;

public class _378_Kth_Smallest_Element_In_A_Sorted_Matrix {
    private record Coordinate(int row, int col) {}
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        PriorityQueue<Coordinate> pq = new PriorityQueue<>((a, b) -> (matrix[a.row][a.col] - matrix[b.row][b.col]));
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        pq.offer(new Coordinate(0, 0));

        for (int i = 0; i < k - 1; i++) {
            Coordinate coordinate = pq.poll();
            int row = coordinate.row;
            int col = coordinate.col;
            if (row < N - 1 && !visited[row + 1][col]) {
                visited[row + 1][col] = true;
                pq.offer(new Coordinate(row + 1, col));
            }
            if (col < N - 1 && !visited[row][col + 1]) {
                visited[row][col + 1] = true;
                pq.offer(new Coordinate(row, col + 1));
            }
        }
        Coordinate coordinate = pq.poll();
        return matrix[coordinate.row][coordinate.col];
    }
}
