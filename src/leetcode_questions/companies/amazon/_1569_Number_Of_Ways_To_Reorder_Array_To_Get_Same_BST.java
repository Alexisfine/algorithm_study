package leetcode_questions.companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1569_Number_Of_Ways_To_Reorder_Array_To_Get_Same_BST {
    private long modulus = (long) 1e9 + 7;
    private long[][] table;

    public int numOfWays(int[] nums) {
        int m = nums.length;
        table = new long[m][m];
        for (int i = 0; i < m; i++) {
            table[i][0] = 1;
            table[i][i] = 1;
        }

        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % modulus;
            }
        }

        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int) ((process(arrList) - 1) % modulus);
    }

    private long process(List<Integer> arrList) {
        int N = arrList.size();
        if (N < 3) return 1;
        int root = arrList.get(0);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int cur = arrList.get(i);
            if (arrList.get(i) > root) {
                rightList.add(cur);
            } else leftList.add(cur);
        }
        long left = process(leftList) % modulus;
        long right = process(rightList) % modulus;
        return (((left * right) % modulus) * table[N - 1][leftList.size()]) % modulus;
    }
}
