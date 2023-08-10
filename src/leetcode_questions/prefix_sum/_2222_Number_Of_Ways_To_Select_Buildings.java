package leetcode_questions.prefix_sum;

public class _2222_Number_Of_Ways_To_Select_Buildings {
    public long numberOfWays(String s) {
        int N = s.length();
        int[] preSumZeroes = new int[N];

        for (int i = 1; i < N; i++) {
            preSumZeroes[i] = preSumZeroes[i - 1];
            if (s.charAt(i - 1) == '0') {
                preSumZeroes[i]++;
            }
        }
        long totalZeroes = 0;
        long totalOnes = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '0') {
                totalZeroes++;
            } else {
                totalOnes++;
            }
        }

        long res = 0;
        for (int i = 1; i < N - 1; i++) {
            if (s.charAt(i) == '0') {
                int onesBefore = i - preSumZeroes[i];
                res += onesBefore * (totalOnes - onesBefore);
            } else {
                int zeroesBefore = preSumZeroes[i];
                res += zeroesBefore * (totalZeroes - zeroesBefore);
            }
        }
        return res;
    }
}
