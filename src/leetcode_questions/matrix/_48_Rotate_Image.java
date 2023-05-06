package leetcode_questions.matrix;

public class _48_Rotate_Image {
    // Time: O(N)
    // Space: O(1)
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int tR = 0;
        int tC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (tR < bR) rotateImage(matrix, tR++, tC++, bR--, bC--);
    }

    private static void rotateImage(int[][] matrix, int a, int b, int c, int d) {
        int temp = 0;
        for (int i = 0; i < d-b; i++) {
            temp = matrix[a][b+i];
            matrix[a][b+i] = matrix[c-i][b];
            matrix[c-i][b] = matrix[c][d-i];
            matrix[c][d-i] = matrix[a+i][d];
            matrix[a+i][d] = temp;
        }
    }


}
