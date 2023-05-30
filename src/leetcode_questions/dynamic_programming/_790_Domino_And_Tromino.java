package leetcode_questions.dynamic_programming;

public class _790_Domino_And_Tromino {
    // Time: O(N^2)
    // Space: O(N)
    public static int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long modulo = (long) (Math.pow(10, 9) + 7);
        long[] f = new long[n + 1];
        long[] p = new long[n + 1];
        f[1] = 1;
        f[2] = 2;
        p[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + p[i - 1];
            p[i] = p[i - 1] + f[i - 2];
        }
        long res = f[n] % modulo;
        return (int) res;
    }

    // Time: O(N)
    // Space: O(N)
    public int numTilings2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long modulo = (long) (Math.pow(10, 9) + 7);
        long[] f = new long[n + 1];
        long[] p = new long[n + 1];
        f[1] = 1;
        f[2] = 2;
        p[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2] + 2 * p[i - 1]) % modulo;
            p[i] = (p[i - 1] + f[i - 2]) % modulo;
        }
        long res = f[n] % modulo;
        return (int) res;
    }
    // Time: O(N)
    // Space: O(1)
    public int numTilings3(int n) {
        return 0;
    }
}
