package leetcode_questions.graph.disjoint_set;

public class _323_Number_Of_Connected_Components_In_An_Undirected_Graph {
    // Time: O(E + N)
    // Space: O(N)
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int components = n;
        for (int i = 0; i < edges.length; i++) {
            if (!uf.connected(edges[i][0], edges[i][1])) {
                uf.union(edges[i][0], edges[i][1]);
                components--;
            }
        }
        return components;
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
