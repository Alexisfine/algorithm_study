package leetcode_questions.graph.disjoint_set;

public class _990_Satisfiability_Of_Equality_Equations {
    // Time: O(N)
    // Space: O(1)
    public boolean equationsPossible(String[] equations) {
        int N = equations.length;
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < N; i++) {
            if (equations[i].charAt(1) == '=') {
                char first = equations[i].charAt(0);
                char second = equations[i].charAt(3);
                uf.union(first - 'a', second - 'a');
            }
        }

        for (int i = 0; i < N; i++) {
            if (equations[i].charAt(1) == '!') {
                char first = equations[i].charAt(0);
                char second = equations[i].charAt(3);
                if (uf.connected(first - 'a', second - 'a')) return false;
            }
        }
        return true;
    }

    private class UnionFind {
        int[] root;
        int[] weight;
        public UnionFind(int size) {
            root = new int[size];
            weight = new int[size];
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
            if (weight[rootX] > weight[rootY]) {
                root[rootY] = rootX;
            } else if (weight[rootX] < weight[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                weight[rootX]++;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
