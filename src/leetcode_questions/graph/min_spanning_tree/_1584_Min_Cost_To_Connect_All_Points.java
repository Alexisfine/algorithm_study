package leetcode_questions.graph.min_spanning_tree;

import java.util.*;

public class _1584_Min_Cost_To_Connect_All_Points {
    // Time: O(N ^ 2 * logN)
    // Space: O(N ^ 2)
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                edges.add(List.of(i, j,
                        Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }

        Collections.sort(edges, new DistanceComparator());
        int addedEdges = 0;
        int cost = 0;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < edges.size(); i++) {
            if (addedEdges == N - 1) break;
            int index1 = edges.get(i).get(0);
            int index2 = edges.get(i).get(1);
            int expense = edges.get(i).get(2);
            if (!uf.connected(index1, index2)) {
                uf.union(index1, index2);
                addedEdges++;
                cost += expense;
            }
        }
        return cost;
    }

    private class DistanceComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            return o1.get(2) - o2.get(2);
        }
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

    public int minCostConnectPoints2(int[][] points) {
        int N = points.length;
        HashSet<Integer> added = new HashSet<>(N);
        added.add(0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 1; i < N; i++) {
            pq.add(new int[]{Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]),
                    i});
        }
        int cost = 0;
        while (added.size() < N && !pq.isEmpty()) {
            while (added.contains(pq.peek()[1])) pq.poll();
            int[] next = pq.poll();
            added.add(next[1]);
            cost += next[0];
            int r1 = points[next[1]][0];
            int c1 = points[next[1]][1];
            for (int i = 0; i < N; i++) {
                if (!added.contains(i)) {
                    pq.add(new int[]{Math.abs(r1 - points[i][0]) + Math.abs(c1 - points[i][1]), i});
                }
            }
        }
        return cost;
    }
}
