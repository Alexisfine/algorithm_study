package graph;

import java.util.*;

public class Kruskal {
    public static class MySets {
        public HashMap<Node, List<Node>> setMap;
        public MySets(List<Node> nodes) {
            for (Node node : nodes) {
                List<Node> list = new ArrayList<>();
                list.add(node);
                setMap.put(node, list);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node node : toSet) {
                fromSet.add(node);
                setMap.put(node, fromSet);
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        MySets mySets = new MySets(graph.nodes.values().stream().toList());
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            pq.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!mySets.isSameSet(cur.from, cur.to)) {
                result.add(cur);
                mySets.union(cur.from, cur.to);
            }
        }
        return result;
    }
}
