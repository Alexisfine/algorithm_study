package matrix;

public class SpiralMatrix {
    public static void spiralMatrix(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (tR <= bR && tC <= bC) printEdge(matrix, tR++, tC++, bR--, bC--);
    }

    private static void printEdge(int[][] matrix, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) System.out.println(matrix[a][i]);
        } else if (c == d) {
            for (int i = a; i <= c; i++) System.out.println(matrix[i][b]);
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) System.out.println(matrix[a][curC++]);
            while (curR != c) System.out.println(matrix[curR++][d]);
            while (curC != b) System.out.println(matrix[c][curC--]);
            while (curR != a) System.out.println(matrix[curR--][b]);
        }
    }

}
