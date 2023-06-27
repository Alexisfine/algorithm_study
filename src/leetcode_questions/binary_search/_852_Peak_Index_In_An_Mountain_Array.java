package leetcode_questions.binary_search;

public class _852_Peak_Index_In_An_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 1;
        int hi = arr.length - 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
