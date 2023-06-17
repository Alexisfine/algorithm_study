package leetcode_questions.heap;

import java.util.PriorityQueue;

public class _295_Find_Median_From_Data_Stream {
    public class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            this.minHeap = new PriorityQueue<>();
            this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                minHeap.offer(num);
                return;
            }

            int min = minHeap.peek();
            if (num > min) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            int minHeapSize = minHeap.size();
            int maxHeapSize = maxHeap.size();
            if (minHeapSize == 0 && maxHeapSize == 0) return 0.0;
            else if (minHeapSize == 0) return maxHeap.peek();
            else if (maxHeapSize == 0) return minHeap.peek();
            else if (maxHeapSize == minHeapSize) return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            else if (maxHeapSize > minHeapSize) return maxHeap.peek();
            return minHeap.peek();
        }
    }
}
