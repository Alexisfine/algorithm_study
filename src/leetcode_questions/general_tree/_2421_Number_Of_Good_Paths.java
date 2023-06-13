package leetcode_questions.general_tree;

import java.util.*;

public class _2421_Number_Of_Good_Paths {
    // Union Find + Greedy
    Map<Integer, List<Integer>> graph;
    TreeMap<Integer, List<Integer>> valToNodeMap;
    int[] vals;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        this.vals = vals;
        this.graph = new HashMap<>();
        this.valToNodeMap = new TreeMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < vals.length; i++) {
            valToNodeMap.putIfAbsent(vals[i], new ArrayList<>());
            valToNodeMap.get(vals[i]).add(i);
        }

        int res = 0;
        UnionFind uf = new UnionFind(vals.length);
        for (int val : valToNodeMap.keySet()) {
            for (int node : valToNodeMap.get(val)) {
                if (graph.containsKey(node)) {
                    for (int nextNode : graph.get(node)) {
                        if (vals[nextNode] <= val) {
                            uf.union(node, nextNode);
                        }
                    }
                }
            }
            // for each disjoint set, how many vals does it contain?
            Map<Integer, Integer> count = new HashMap<>();
            for (int node : valToNodeMap.get(val)) {
                int root = uf.find(node);
                count.put(root, count.getOrDefault(root, 0) + 1);
                res += count.get(root);
            }
        }
        return res;
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
