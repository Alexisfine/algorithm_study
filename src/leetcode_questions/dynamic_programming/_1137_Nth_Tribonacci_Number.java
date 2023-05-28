package leetcode_questions.dynamic_programming;

public class _1137_Nth_Tribonacci_Number {
    // Time: O(N)
    // Space: O(1)
    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        int zero = 0;
        int one = 1;
        int two = 1;
        for (int i = 3; i <= n; i++) {
            int temp = zero + one + two;
            zero = one;
            one = two;
            two = temp;
        }
        return two;
    }
}
