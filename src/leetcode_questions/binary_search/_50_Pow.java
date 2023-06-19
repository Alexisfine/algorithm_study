package leetcode_questions.binary_search;

public class _50_Pow {
    public double myPow(double x, int n) {
        return helper(x, (long) n);
    }

    private double helper(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }
        double res = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                res = res * x;
                x--;
            }
            x = x * x;
            n /= 2;
        }
        return res;
    }
}
