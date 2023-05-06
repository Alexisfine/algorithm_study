package matrix;

public class ZigZag {
    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bR = bR == endR ? bR : bR + 1;
            bC = bR == endR ? bC + 1 : bC;
            fromUp = !fromUp;
        }
    }
    public static void printLevel(int[][] matrix, int tR, int tC, int bR, int bC, boolean f) {
        if (f) {
            while (tR != bR + 1) {
                System.out.println(matrix[tR++][tC--]);
            }
        } else {
            while (bR != tR - 1) {
                System.out.println(matrix[bR--][bC++]);
            }
        }
    }
}
