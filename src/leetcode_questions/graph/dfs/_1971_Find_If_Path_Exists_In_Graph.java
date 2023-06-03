package leetcode_questions.graph.dfs;

public class _1971_Find_If_Path_Exists_In_Graph {
    // Time: O(N + E)
    // Space: O(N)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.connected(source, destination);
    }

    private class UnionFind {
        int[] weight;
        int[] root;
        public UnionFind(int size) {
            this.weight = new int[size];
            this.root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                weight[i] = 1;
            }
        }
        public int find(int x) {
            if (root[x] == x) return x;
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
