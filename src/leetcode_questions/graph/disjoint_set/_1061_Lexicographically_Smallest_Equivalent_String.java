package leetcode_questions.graph.disjoint_set;

public class _1061_Lexicographically_Smallest_Equivalent_String {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        char[] representation = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i) < s2.charAt(i) ? s1.charAt(i) : s2.charAt(i);
            int root = uf.find(c - 'a');
            if (representation[root] == '\u0000') {
                representation[root] = c;
            } else {
                representation[root] = representation[root] < c ? representation[root] : c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char next = baseStr.charAt(i);
            char next2 = representation[uf.find(next - 'a')];
            if (next2 != '\u0000') {
                next = next2;
            }
            sb.append(next);
        }
        return new String(sb);

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
