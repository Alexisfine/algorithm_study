package leetcode_questions.graph.disjoint_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _399_Evaluate_Division {
    // Method 1: Graph + DFS
    // M: equations
    // N: queries
    // Time: O(M * N)
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, (double) 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                res[i] = -1.0;
            } else if (dividend == divisor) {
                res[i] = 1.0;
            } else {
                HashSet<String> visited = new HashSet<>();
                res[i] = search(graph, dividend, divisor, 1.0, visited);
            }
        }

        return res;
    }

    private double search(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode,
                          double currentProduct, HashSet<String> visited) {
        visited.add(currNode);
        double ret = -1.0;
        HashMap<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode)) {
            ret = currentProduct * neighbors.get(targetNode);
        } else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode)) continue;
                ret = search(graph, nextNode, targetNode, currentProduct * pair.getValue(), visited);
                if (ret != -1.0) break;
            }
        }

        visited.remove(currNode);
        return ret;
    }

    // Method 2: Union Find
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the union groups
        HashMap<String, HashMap<String, Double>> gidWeight = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];

//            union(gidWeight, dividend, divisor, quotient);
        }

        // Step 2: Run the evaluation, with lazy updates in find() function
//        double[] results = new double[queries.size()];
//        for (int i = 0; i < queries.size(); i++) {
//            List<String> query = queries.get(i);
//            String dividend = query.get(0);
//            String divisor = query.get(1);
//            if (!gidWeight.containsKey(dividend) || !gidWeight.containsKey(divisor)) {
//                results[i] = -1.0;
//            } else {
//                HashMap<String, Double> dividendEntry = find(gidWeight, dividend);
//                HashMap<String, Double> divisorEntry = find(gidWeight, divisor);
//                String dividendGid = dividendEntry.keySet();
//            }
//        }
        return null;
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
