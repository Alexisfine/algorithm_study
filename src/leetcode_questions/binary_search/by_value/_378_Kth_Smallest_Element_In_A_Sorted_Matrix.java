package leetcode_questions.binary_search.by_value;

public class _378_Kth_Smallest_Element_In_A_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = Integer.MIN_VALUE / 2;
        int hi = Integer.MAX_VALUE / 2;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = countSmallerOrEqual(matrix, mid);
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int countSmallerOrEqual(int[][] matrix, int num) {
        int M = matrix.length;
        int N = matrix[0].length;

        int i = M - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < N) {
            if (matrix[i][j] <= num) {
                count += (i + 1);
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
