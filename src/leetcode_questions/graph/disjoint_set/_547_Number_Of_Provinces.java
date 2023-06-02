package leetcode_questions.graph.disjoint_set;

public class _547_Number_Of_Provinces {
    // Time: O(N^2)
    // Space: O(N)
    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        UnionFind uf = new UnionFind(N);
        int provinces = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1 && !uf.connected(i, j)) {
                    uf.union(i, j);
                    provinces--;
                }
            }
        }
        return provinces;
    }

    private class UnionFind {
        int[] root;
        int[] height;
        public UnionFind(int size) {
            this.root = new int[size];
            this.height = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                height[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (height[rootX] > height[rootY]) {
                    root[rootY] = rootX;
                } else if (height[rootX] < height[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    height[rootX]++;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
