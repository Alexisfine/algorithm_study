package leetcode_questions.graph.min_spanning_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1135_Connecting_Cities_With_Minimum_Cost {
    // Time: O(MlogM)
    // Space: O(N)
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
        UnionFind uf = new UnionFind(n + 1);
        int connectedEdges = 0;
        int cost = 0;
        for (int i = 0; i < connections.length; i++) {
            if (!uf.connected(connections[i][0], connections[i][1])) {
                uf.union(connections[i][0], connections[i][1]);
                cost += connections[i][2];
                connectedEdges++;
            }
        }
        return connectedEdges + 1 == n ? cost : -1;
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
