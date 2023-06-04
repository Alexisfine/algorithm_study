package leetcode_questions.graph.tarjan;

import java.util.*;

public class _1192_Critical_Connections_In_A_Network {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        buildGraph(graph, connections);

        int[] id = new int[n];
        Arrays.fill(id, -1);
        List<List<Integer>> res = new ArrayList<>();
        process(0, 0, -1, id, graph, res);
        return res;
    }

    private int process(int curNode, int nodeIdInferred, int parentNode, int[] id,
                        HashMap<Integer, Set<Integer>> graph, List<List<Integer>> res) {

        id[curNode] = nodeIdInferred;
        Set<Integer> set = graph.get(curNode);
        for (int neighbor : set) {
            if (neighbor == parentNode) continue;
            else if (id[neighbor] == -1) {
                id[curNode] = Math.min(id[curNode],
                        process(neighbor, nodeIdInferred + 1, curNode, id, graph, res));
            } else {
                id[curNode] = Math.min(id[curNode], id[neighbor]);
            }
        }

        if (id[curNode] == nodeIdInferred && curNode != 0) {
            res.add(List.of(parentNode, curNode));
        }
        return id[curNode];
    }

    private void buildGraph(Map<Integer, Set<Integer>> graph, List<List<Integer>> connections) {
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> edge = connections.get(i);
            Integer sideA = edge.get(0);
            Integer sideB = edge.get(1);
            graph.putIfAbsent(sideA, new HashSet<>());
            graph.putIfAbsent(sideB, new HashSet<>());
            graph.get(sideA).add(sideB);
            graph.get(sideB).add(sideA);
        }
    }
}
