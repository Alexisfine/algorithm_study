package leetcode_questions.companies.amazon;

import java.util.LinkedList;
import java.util.List;

public class _60_Permutation_Sequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[10];
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int a = k / factorial[n - 1];
            sb.append(list.get(a));
            list.remove(a);
            k -= a * factorial[n - 1];
            n--;
        }
        return new String(sb);
    }

}
