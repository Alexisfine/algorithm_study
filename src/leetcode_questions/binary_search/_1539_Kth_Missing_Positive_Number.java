package leetcode_questions.binary_search;

public class _1539_Kth_Missing_Positive_Number {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] - mid - 1 < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo + k;
    }
}
