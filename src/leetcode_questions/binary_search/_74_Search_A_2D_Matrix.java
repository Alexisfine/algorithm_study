package leetcode_questions.binary_search;

public class _74_Search_A_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int M = matrix.length;
        int N = matrix[0].length;

        int left = 0;
        int right = M * N - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / N][pivotIdx % N];
            if (target == pivotElement) return true;
            else if (target < pivotElement) right = pivotIdx - 1;
            else left = pivotIdx + 1;
        }
        return false;
    }
}
