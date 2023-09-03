package leetcode_questions.dynamic_programming.basic_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int N = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        List<Integer> arr = new ArrayList<>();
        arr.add(envelopes[0][1]);
        for (int i = 1; i < N; i++) {
            int curWidth = envelopes[i][1];
            if (arr.isEmpty() || arr.get(arr.size() - 1) < curWidth) {
                arr.add(curWidth);
            } else {
                int index = binarySearch(arr, curWidth);
                arr.set(index, Math.min(arr.get(index), curWidth));
            }
        }
        return arr.size();
    }

    private int binarySearch(List<Integer> arr, int k) {
        int lo = 0;
        int hi = arr.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) == k) return mid;
            else if (arr.get(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /*
    sort by length first, then the max envelope will be one of its subsequence
    the solution will be LIS

    find LIS
    dp[i] the maximum length of Russian doll sequence if i-th envelope is the largest one
     */
}
