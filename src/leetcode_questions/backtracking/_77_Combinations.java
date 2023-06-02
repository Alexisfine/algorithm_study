package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    int n;
    int k;
    List<List<Integer>> res;
    List<Integer> list;

    // Time: O(k * C(n,k) )
    // Space: O(k)
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        process(0, 0);
        return res;
    }

    private void process(int index, int elements) {
        // base cases
        if (elements == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == n) return;

        // not choose you
        process(index + 1, elements);

        // choose you
        list.add(index + 1);
        process(index + 1, elements + 1);
        list.remove(list.size() - 1);
    }
}
