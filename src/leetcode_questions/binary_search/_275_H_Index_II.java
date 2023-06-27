package leetcode_questions.binary_search;

public class _275_H_Index_II {
    public int hIndex(int[] citations) {
        int N = citations.length;
        int lo = 0;
        int hi = N - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (N - mid <= citations[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (N - lo <= citations[lo]) return N - lo;
        return 0;
    }
}
