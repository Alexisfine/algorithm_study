package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _778_Swim_In_Rising_Water {
    public int swimInWater(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Set<List<Integer>> visited = new HashSet<>();
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] time = new int[M][N];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curPos = pq.poll();
            int row = curPos[0];
            int col = curPos[1];
            int max = curPos[2];

            List<Integer> list = List.of(row, col);
            if (visited.contains(list)) continue;
            visited.add(list);
            time[row][col] = max;

            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextCol < 0 || nextRow == M || nextCol == N) continue;
                List<Integer> nextPos = List.of(nextRow, nextCol);
                if (visited.contains(nextPos)) continue;
                pq.offer(new int[]{nextRow, nextCol, Math.max(max, grid[nextRow][nextCol])});
            }
        }

        return time[M - 1][N - 1];
    }
}
