package leetcode_questions.binary_search;

public class _1802_Maximum_Value_At_A_Given_Index_In_A_Bounded_Array {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 1;
        int hi = maxSum;
        int currentBest = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean isValid = isValid(n, index, maxSum, mid);
            if (isValid) {
                currentBest = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return currentBest;
    }

    private boolean isValid(int n, int index, int maxSum, int maxVal) {
        if (maxVal == 1) return n <= maxSum;
        int leftElements = Math.min(maxVal, index + 1);
        int rightElements = Math.min(maxVal - 1, n - index - 1);
        long leftStart = maxVal - leftElements + 1;
        long rightStart = maxVal - 1;
        long rightEnd = maxVal - rightElements;
        long sum = ((leftStart + maxVal) * leftElements / 2) + ((rightStart + rightEnd) * rightElements / 2);
        int restLeft = index - leftElements + 1;
        sum += restLeft;
        int restRight = n - index - rightElements - 1;
        sum += restRight;
        return sum <= maxSum;
    }
}
