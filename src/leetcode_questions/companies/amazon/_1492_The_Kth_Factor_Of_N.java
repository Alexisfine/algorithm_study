package leetcode_questions.companies.amazon;

public class _1492_The_Kth_Factor_Of_N {
    public int kthFactor(int n, int k) {
        int max = (int) Math.sqrt(n);
        for (int i = 1; i <= max; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) return i;
            }
        }

        for (int i = max * max == n ? max - 1 : max; i >= 1; i--) {
            if (n % i == 0) {
                k--;
                if (k == 0) return n / i;
            }
        }
        return -1;
    }
}
