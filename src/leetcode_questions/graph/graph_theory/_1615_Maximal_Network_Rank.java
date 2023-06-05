package leetcode_questions.graph.graph_theory;

public class _1615_Maximal_Network_Rank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        boolean[][] isConnected = new boolean[n][n];

        for (int i = 0; i < roads.length; i++) {
            count[roads[i][0]]++;
            count[roads[i][1]]++;
            isConnected[roads[i][0]][roads[i][1]] = true;
            isConnected[roads[i][1]][roads[i][0]] = true;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, count[i] + count[j] - (isConnected[i][j] ? 1 : 0));
            }
        }
        return max;
    }
}
