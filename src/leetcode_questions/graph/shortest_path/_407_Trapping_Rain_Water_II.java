package leetcode_questions.graph.shortest_path;

import java.util.PriorityQueue;

public class _407_Trapping_Rain_Water_II {
    private record Info(int x, int y, int height) {}
    public int trapRainWater(int[][] heightMap) {
        int M = heightMap.length;
        int N = heightMap[0].length;
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == M - 1 || j == 0 || j == N - 1) {
                    pq.offer(new Info(i, j, heightMap[i][j]));
                }
            }
        }
        int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int seaLevel = Integer.MIN_VALUE;
        int res = 0;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            if (cur.height > seaLevel) seaLevel = cur.height;
            res += seaLevel - cur.height;
            for (int[] direction : directions) {
                int i = cur.x + direction[0];
                int j = cur.y + direction[1];
                if (i < 0 || j < 0 || i == M || j >= N) continue;
                if (visited[i][j]) continue;
                pq.offer(new Info(i, j, heightMap[i][j]));
            }
        }
        return res;
    }
}
