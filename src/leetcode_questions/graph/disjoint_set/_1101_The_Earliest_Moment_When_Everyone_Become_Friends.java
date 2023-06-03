package leetcode_questions.graph.disjoint_set;

import java.util.Arrays;
import java.util.Comparator;

public class _1101_The_Earliest_Moment_When_Everyone_Become_Friends {
    // N: number of people
    // M: number of logs
    // Time: O(N + MlogM + M)
    // Space: O(N + logM)
    public int earliestAcq(int[][] logs, int n) {
        if (logs.length < n - 1) return -1;
        Arrays.sort(logs, new TimeStampComparator());
        int components = n;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < logs.length; i++) {
            if (!uf.connected(logs[i][1], logs[i][2])) {
                uf.union(logs[i][1], logs[i][2]);
                components--;
            }
            if (components == 1) {
                return logs[i][0];
            }
        }
        return -1;
    }

    private class TimeStampComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
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
