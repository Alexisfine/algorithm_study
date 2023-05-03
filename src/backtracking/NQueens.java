package backtracking;

public class NQueens {
    public static int num1(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process1(0, record, n);
    }

    // returns legal ways to arrange all queens
    public static int process1(int i, int[] record, int n) {
        if (i == n) return 1; // terminating
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) return false;
        }
        return true;
    }

    // less than 32 queen
    public static int num2(int n) {
        if (n < 1 || n > 32) return 0;
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, new int[5], 0);
    }

    public static int process2(int i, int[] record, int n) {
        return 0;
    }
}
