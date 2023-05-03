package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectedNode = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNode);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node node = edge.to;
                if (!distanceMap.containsKey(node)) distanceMap.put(node, distance + edge.weight);
                distanceMap.put(node, Math.min(distanceMap.get(node), distance + edge.weight));
            }
            selectedNode.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNode);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> map, HashSet<Node> set) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!set.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static class NodeRecord {
        public Node node;
        public int distance;
        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        public Node[] nodes;
        public HashMap<Node, Integer> heapIndexMap;
        public HashMap<Node, Integer> distanceMap;
        public int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {

        }

        public NodeRecord poll() {
            return null;
        }

        private void insertHeapify(Node node, int index) {

        }

        private void heapify(int index, int size) {

        }

        private boolean isEntered(Node node) {
            return false;
        }

        private boolean inHeap(Node node) {
            return false;
        }

        private void swap(int index1, int index2) {

        }
    }


    // optimized dijkstra beginning from head
    public static Map<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        Map<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.poll();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
}
