package leetcode_questions.heap;

import heap.TopKTimes;

import java.util.HashMap;

public class _347_TopK_Frequent_Elements {

    // Solution 1: Heap
    // Time: O(NlogK)
    // Space: O(N+K)
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return new int[]{};
        TopKRecord heap = new TopKRecord(k);
        for (int i = 0; i < nums.length; i++) heap.add(nums[i]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = heap.remove().value;
        return ans;
    }

    private static class Node {
        int value;
        int times;
        public Node(int value, int times) {
            this.value = value;
            this.times = times;
        }
    }

    private static class TopKRecord {
        Node[] heap;
        int index;
        HashMap<Integer, Node> numToNodeMap;
        HashMap<Node, Integer> nodeIndexMap;
        public TopKRecord(int k) {
            heap = new Node[k];
            index = 0;
            numToNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void add(int num) {
            Node curNode = null;
            int preIndex = -1;
            if (!numToNodeMap.containsKey(num)) {
                curNode = new Node(num, 1);
                numToNodeMap.put(num, curNode);
                nodeIndexMap.put(curNode, -1);
            } else {
                curNode = numToNodeMap.get(num);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }

            if (preIndex == -1) {
                if (index == heap.length) {
                    if (curNode.times > heap[0].times) {
                        nodeIndexMap.put(heap[0], -1);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, index);
                    }
                } else {
                    heap[index] = curNode;
                    nodeIndexMap.put(curNode, index);
                    heapInsert(index++);
                }
            } else {
                heapify(preIndex, index);
            }
        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[parent].times > heap[index].times) {
                    swap(parent, index);
                    index = parent;
                } else break;
            }
        }

        private void heapify(int index, int size) {
            int l = 2 * index + 1;
            int r = 2 * index + 2;
            int smallest = 0;
            while (l < size) {
                if (heap[l].times < heap[index].times) smallest = l;
                if (r < size && heap[r].times < heap[smallest].times) smallest = r;
                if (smallest != index) {
                    swap(index, smallest);
                    index = smallest;
                    l = 2 * index + 1;
                    r = 2 * index + 2;
                } else break;
            }
        }

        private void swap(int a, int b) {
            nodeIndexMap.put(heap[a], b);
            nodeIndexMap.put(heap[b], a);
            Node temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;
        }

        private Node remove() {
            Node cur = heap[0];
            nodeIndexMap.remove(cur);
            numToNodeMap.remove(cur.value);
            swap(0, --index);
            heapify(0, index);
            return cur;
        }
    }

    // Solution 2: Quick select
    // Time: O(N) average
    // Space: O(N)
}
