package dynamic_programming;

public class MaximalSquare {
    // Time: O(N^4)
    public static int max1(int[][] matrix) {
        if (matrix == null || matrix.length < 1) return 0;
        int M = matrix.length;
        int N = matrix[0].length;
        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                //enumerate side length
                for (int diag = 1; row + diag < M && col + diag < N; diag++) {
                    // (row, col), len = diag
                    // validate if the square's border is all 1
                    // for {}  side 1
                    // for {}  side 2
                    // for {}  side 3
                    // for {}  side 4
                }
            }
        }
        return 0;
    }
}
