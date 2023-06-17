package leetcode_questions.greedy;

public class _1529_Minimum_Suffix_Flips {
    public int minFlips(String target) {
        int N = target.length();
        boolean one = true;
        int res = 1;
        int index = 0;
        while (index < N && target.charAt(index) == '0') index++;

        if (index == N) return 0;

        for (int i = index; i < N; i++) {
            if (one && target.charAt(i) == '0') {
                one = false;
                res++;
            } else if (!one && target.charAt(i) == '1') {
                one = true;
                res++;
            }
        }
        return res;
    }
}
