package leetcode_questions.greedy.two_pass;

import java.util.Arrays;

public class _135_Candy {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int[] res = new int[N];
        Arrays.fill(res, 1);
        int sum = 0;
        for (int i = 1; i < N; i++) {
            res[i] = (ratings[i] > ratings[i - 1]) ? res[i - 1] + 1 : 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }

        for (int val : res) sum += val;
        return sum;
    }
}
