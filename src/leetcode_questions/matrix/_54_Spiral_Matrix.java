package leetcode_questions.matrix;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {
    // Time: O(M*N)
    // Space: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        int tX = 0;
        int tY = 0;
        int bX = matrix[0].length - 1;
        int bY = matrix.length - 1;
        while (tX <= bX && tY <= bY) traverseSpiral(matrix, list, tY++, tX++, bY--, bX--);
        return list;
    }

    private static void traverseSpiral(int[][] matrix, List<Integer> list, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) list.add(matrix[a][i]);
        } else if (b == d) {
            for (int i = a; i <= c; i++) list.add(matrix[i][b]);
        } else {
            int curX = b;
            int curY = a;
            while (curX != d) list.add(matrix[a][curX++]);
            while (curY != c) list.add(matrix[curY++][d]);
            while (curX != b) list.add(matrix[c][curX--]);
            while (curY != a) list.add(matrix[curY--][b]);
        }
    }
}
