package leetcode_questions.matrix;

public class _59_Spiral_Matrix_II {
    int cur = 1;
    boolean flag = false;
    int size;
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 0;
        size = n * n;
        for (int i = n; i >= 0; i-=2) {
            if (flag) break;
            fill(arr, c, c, i);
            c++;
        }
        return arr;
    }

    private  void fill(int[][] arr, int i, int j, int len) {
        // top
        for (int a = 0; a < len; a++) {
            arr[i][j + a] = cur++;
            if (cur > size) {
                flag = true;
                return;
            }
        }

        // right
        for (int a = 1; a < len; a++) {
            arr[i + a][j + len - 1] = cur++;
            if (cur > size) {
                flag = true;
                return;
            }
        }

        // down
        for (int a = 1; a < len; a++) {
            arr[i + len - 1][j + len - 1 - a] = cur++;
            if (cur > size) {
                flag = true;
                return;
            }
        }

        // up
        for (int a = 1; a < len - 1; a++) {
            arr[i + len - 1 - a][j] = cur++;
            if (cur > size) {
                flag = true;
                return;
            }
        }
    }


}
