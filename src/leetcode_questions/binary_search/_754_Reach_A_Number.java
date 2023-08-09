package leetcode_questions.binary_search;

public class _754_Reach_A_Number {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int i = 0;
        while (!(sum >= target && (sum - target) % 2 == 0)) {
            i++;
            sum += i;
        }
        return i;
    }
}
