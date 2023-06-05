package leetcode_questions.graph.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class _417_Pacific_Atlantic_Water_Flow {
    int M;
    int N;
    int[][] heights;
    public record Coordinate(int row, int col) {}

    // Time: O(M * N)
    // Space: O(M * N)
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.M = heights.length;
        this.N = heights[0].length;
        this.heights = heights;
        HashSet<Coordinate> pacific = new HashSet<>();
        HashSet<Coordinate> atlantic = new HashSet<>();

        for (int i = 0; i < N; i++) {
            process(new Coordinate(0, i), pacific, heights[0][i]);
            process(new Coordinate(M - 1, i), atlantic, heights[M - 1][i]);
        }

        for (int i = 0; i < M; i++) {
            process(new Coordinate(i, 0), pacific, heights[i][0]);
            process(new Coordinate(i, N - 1), atlantic, heights[i][N - 1]);
        }

        List<List<Integer>> res =  new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if (pacific.contains(coordinate) && atlantic.contains(coordinate)) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void process(Coordinate coordinate, HashSet<Coordinate> visited, int prevHeight) {
        if (coordinate.row < 0 || coordinate.col < 0 || coordinate.row == M || coordinate.col == N
                || visited.contains(coordinate)) {
            return;
        }

        int height = heights[coordinate.row][coordinate.col];

        if (height < prevHeight) return;
        visited.add(coordinate);
        process(new Coordinate(coordinate.row + 1, coordinate.col), visited, height);
        process(new Coordinate(coordinate.row - 1, coordinate.col), visited, height);
        process(new Coordinate(coordinate.row, coordinate.col + 1), visited, height);
        process(new Coordinate(coordinate.row, coordinate.col - 1), visited, height);
    }
}
