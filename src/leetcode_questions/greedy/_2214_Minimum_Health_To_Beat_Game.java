package leetcode_questions.greedy;

public class _2214_Minimum_Health_To_Beat_Game {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 1;
        long max = damage[0];
        for (int i = 0; i < damage.length; i++) {
            sum += damage[i];
            max = Math.max(max, damage[i]);
        }
        if (max >= armor) {
            sum -= max - (max - armor);
        } else {
            sum -= max;
        }
        return sum;
    }
}
