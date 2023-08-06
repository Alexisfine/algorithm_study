package leetcode_questions.companies.jpm;

public class _JPM_357_Count_Numbers_With_Unique_Digits {
    /**
     * permutation
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for (int len = 1; len <= n; len++) {
            res += A(10, len) - A(9, len - 1);
        }
        return res;
    }

    private int A(int m, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (m - i);
        }
        return res;
    }
}
