package leetcode_questions.matrix;

public class _73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean rowZero = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0)  matrix[i][0] = 0;
                    else rowZero = true;
                }
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }

        if (rowZero) {
            for (int i = 0; i < N; i++) {
                matrix[0][i] = 0;
            }
        }
    }

}
