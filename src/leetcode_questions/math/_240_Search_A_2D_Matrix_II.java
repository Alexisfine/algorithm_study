package leetcode_questions.math;

public class _240_Search_A_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int row = 0;
        int col = N - 1;
        while (col >= 0 && row < M) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
