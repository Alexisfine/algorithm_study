package leetcode_questions.graph.min_spanning_tree;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1168_Optimize_Water_Distribution_In_A_Village {
    // Time: O(N+M logN+M)
    // Space: O(N + M)
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        UnionFind uf = new UnionFind(n + 1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < pipes.length; i++) {
            pq.offer(pipes[i]);
        }
        for (int i = 0; i < wells.length; i++) {
            pq.offer(new int[]{0, i + 1, wells[i]});
        }

        int cost = 0;
        while (!pq.isEmpty()) {
            int[] pipe = pq.poll();
            int from = pipe[0];
            int to = pipe[1];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
                cost += pipe[2];
            }
        }
        return cost;
    }

    private class UnionFind {
        int[] root;
        int[] weight;
        public UnionFind(int size) {
            this.root = new int[size];
            this.weight = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) return x;
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (weight[rootX] > weight[rootY]) {
                    root[rootY] = rootX;
                } else if (weight[rootX] < weight[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    weight[rootX]++;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
