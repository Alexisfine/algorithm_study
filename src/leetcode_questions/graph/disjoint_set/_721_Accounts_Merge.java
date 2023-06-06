package leetcode_questions.graph.disjoint_set;

import java.util.*;

public class _721_Accounts_Merge {
    // Time: O(NK logNK)
    // Space: O(NK)
    // N: number of accounts, K: longest length of an account
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String str = accounts.get(i).get(j);
                if (!map.containsKey(str)) {
                    map.put(str, i);
                } else {
                    uf.union(map.get(str), i);
                }
            }
        }

        Map<Integer, List<String>> map2 = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int index = uf.find(entry.getValue());
            map2.putIfAbsent(index, new ArrayList<>());
            map2.get(index).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map2.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(entry.getKey()).get(0));
            Collections.sort(entry.getValue());
            list.addAll(entry.getValue());
            res.add(list);
        }
        return res;
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
