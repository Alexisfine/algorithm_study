package heap;

import java.util.HashMap;

public class TopKTimes {
    private static class Node {
        String str;
        int times;
        public Node(String s, int t) {
            this.str = s;
            this.times = t;
        }
    }

    private static class TopKRecord {
        private Node[] heap;
        private int index;
        private HashMap<String, Node> strNodeMap;
        private HashMap<Node, Integer> nodeIndexMap;
        public TopKRecord(int k) {
            heap = new Node[k];
            index = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }

            if (preIndex == -1) {
                if (index == heap.length) {
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, index);
                    }
                } else {
                    nodeIndexMap.put(curNode, index);
                    heap[index] = curNode;
                    heapInsert(index++);
                }
            } else {
                heapify(preIndex, index);
            }
        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap(parent, index);
                    index = parent;
                } else break;
            }
        }

        private void heapify(int index, int heapSize) {
            int l = index * 2 + 1;
            int r = index * 2 + 2;
            int smallest = index;
            while (l < heapSize) {
                if (heap[l].times < heap[index].times) {
                    smallest = l;
                }
                if (r < heapSize && heap[r].times < heap[smallest].times) {
                    smallest = r;
                }
                if (smallest != index) {
                    swap(index, smallest);
                } else break;

                index = smallest;
                l = index * 2 + 1;
                r = index * 2 + 2;
            }
        }

        private void swap(int a, int b) {
            nodeIndexMap.put(heap[a], b);
            nodeIndexMap.put(heap[b], a);
            Node temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }
    }
}
