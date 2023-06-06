package leetcode_questions.graph.disjoint_set;

public class _839_Similar_String_Groups {
    String[] strs;
    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) return 0;
        int N = strs.length;
        this.strs = strs;
        UnionFind uf = new UnionFind(N);

        int groups = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (!uf.connected(i, j) && isSimilar(i, j)) {
                    uf.union(i, j);
                    groups--;
                }
            }
        }
        return groups;
    }

    private boolean isSimilar(int str1, int str2) {
        int len = strs[str1].length();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (strs[str1].charAt(i) != strs[str2].charAt(i)) diff++;
            if (diff > 2) break;
        }
        return diff <= 2;
    }

    private static class UnionFind {
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
