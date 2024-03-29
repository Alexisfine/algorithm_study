package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
      public static class EdgeComparator implements Comparator<Edge> {

          @Override
          public int compare(Edge o1, Edge o2) {
              return o1.weight - o2.weight;
          }
      }

      public static Set<Edge> primMST(Graph graph) {
          PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
          HashSet<Node> set = new HashSet<>();
          Set<Edge> result = new HashSet<>();
          for (Node node : graph.nodes.values()) {

              if (!set.contains(node)) {
                  set.add(node);
                  for (Edge edge : node.edges) pq.add(edge);
              }
              while (!pq.isEmpty()) {
                  Edge edge = pq.poll();
                  Node toNode = edge.to;
                  if (!set.contains(toNode)) {
                      set.add(toNode);
                      result.add(edge);
                      for (Edge nextEdge : toNode.edges) pq.add(nextEdge);
                  }
              }
          }
          return result;
      }
}
