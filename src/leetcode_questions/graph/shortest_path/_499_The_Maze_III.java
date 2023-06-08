package leetcode_questions.graph.shortest_path;

import java.util.*;

public class _499_The_Maze_III {
    public record Path(int row, int col, int distance, String str) {}
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int M = maze.length;
        int N = maze[0].length;
        String[][] distance = new String[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = "impossible";
            }
        }
        distance[ball[0]][ball[1]] = "";


        PriorityQueue<Path> pq = new PriorityQueue<>(new PathComparator());
        Set<List<Integer>> visited = new HashSet<>();
        pq.add(new Path(ball[0], ball[1], 0, ""));

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            Path pathCur = pq.poll();
            List<Integer> curPos = List.of(pathCur.row, pathCur.col);
            if (visited.contains(curPos)) continue;;
            visited.add(curPos);
            distance[pathCur.row][pathCur.col] = pathCur.str;

            for (int[] direction : directions) {
                int delta = 1;
                while (true) {
                    int nextRow = pathCur.row + delta * direction[0];
                    int nextCol = pathCur.col + delta * direction[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow == M || nextCol == N) break;
                    else if (nextRow == hole[0] && nextCol == hole[1]) {
                        delta++;
                        break;
                    }
                    else if (maze[nextRow][nextCol] == 0) delta++;
                    else break;
                }
                delta--;

                char path = 'u';
                if (direction[0] == 1) path = 'd';
                else if (direction[1] == 1) path = 'r';
                else if (direction[1] == -1) path = 'l';

                int nextRow = pathCur.row + delta * direction[0];
                int nextCol = pathCur.col + delta * direction[1];
                List<Integer> nextPos = List.of(nextRow, nextCol);
                if (!visited.contains(nextPos)) {
                    pq.offer(new Path(nextRow, nextCol, pathCur.distance + delta, pathCur.str + path));
                }
            }
        }
        return distance[hole[0]][hole[1]];
    }

    // {row, col, distance, str}
    private class PathComparator implements Comparator<Path> {

        @Override
        public int compare(Path p1, Path p2) {
            if (p1.distance != p2.distance) return p1.distance - p2.distance;
            return String.CASE_INSENSITIVE_ORDER.compare(p1.str, p2.str);
        }
    }
}
