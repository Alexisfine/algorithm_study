package leetcode_questions.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _1765_Map_Of_Highest_Peak {
    public int[][] highestPeak(int[][] isWater) {
        int M = isWater.length;
        int N = isWater[0].length;

        int[][] res = new int[M][N];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j] = isWater[i][j] == 1 ? 0 : -1;
                if (isWater[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] position = queue.poll();
                int row = position[0];
                int col = position[1];
                res[row][col] = Math.min(res[row][col], height);
                if (isValid(row - 1, col, res)) {
                    queue.add(new int[]{row - 1, col});
                }

                if (row < M - 1 && isValid(row + 1, col, res)) {
                    queue.add(new int[]{row + 1, col});
                }

                if (col > 0 && isValid(row, col - 1, res)) {
                    queue.add(new int[]{row, col - 1});
                }

                if (col < N - 1 && isValid(row, col + 1, res)) {
                    queue.add(new int[]{row, col + 1});
                }
            }
            height++;
        }
        return res;
    }

    private boolean isValid(int i, int j, int[][] water) {
        return (i >= 0) && (j >= 0) && (i < water.length ) && (j < water.length) && water[i][j] == -1;
    }
}
