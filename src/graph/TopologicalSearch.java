package graph;

import java.sql.Array;
import java.util.*;

public class TopologicalSearch {
    public static List<Node> topologicalSearch(Graph graph) {
        // key: node
        // val: remaining ins
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node n : graph.nodes.values()) {
            inMap.put(n, n.in);
            if (n.in == 0) zeroInQueue.add(n);
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) zeroInQueue.add(next);
            }
        }
        return result;
    }
}
