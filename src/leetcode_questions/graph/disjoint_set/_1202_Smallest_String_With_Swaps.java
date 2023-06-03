package leetcode_questions.graph.disjoint_set;

import java.util.*;

public class _1202_Smallest_String_With_Swaps {
    // Time: O(E + V + VlogV)
    // Space: O(V)
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (int i = 0; i < pairs.size(); i++) {
            uf.union(pairs.get(i).get(0), pairs.get(i).get(1));
        }

        // Group all nodes with same root together
        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(i);
        }

        char[] smallestString = new char[s.length()];
        for (List<Integer> indices : rootToComponent.values()) {
            List<Character> characters = new ArrayList<>();
            for (int index : indices) {
                characters.add(s.charAt(index));
            }
            Collections.sort(characters);
            for (int i = 0; i < indices.size(); i++) {
                smallestString[indices.get(i)] = characters.get(i);
            }
        }
        return new String(smallestString);
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
