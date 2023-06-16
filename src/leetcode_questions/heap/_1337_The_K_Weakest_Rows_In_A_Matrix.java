package leetcode_questions.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1337_The_K_Weakest_Rows_In_A_Matrix {
    int[] soldiersMap;
    public int[] kWeakestRows(int[][] mat, int k) {
        int M = mat.length;
        int N = mat[0].length;
        this.soldiersMap = new int[M];
        for (int i = 0; i < M; i++) {
            soldiersMap[i] = binarySearch(mat[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new RowComparator());
        for (int i = 0; i < M; i++) {
            if (pq.size() < k) pq.offer(i);
            else {
                int curSold = soldiersMap[i];
                int topSold = soldiersMap[pq.peek()];
                if (topSold > curSold) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    private class RowComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            int diff = soldiersMap[o2] - soldiersMap[o1];
            if (diff != 0) return diff;
            return o2 - o1;
        }
    }

    private int binarySearch(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int currentCutoff = arr.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == 0) {
                currentCutoff = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return currentCutoff;
    }
}
