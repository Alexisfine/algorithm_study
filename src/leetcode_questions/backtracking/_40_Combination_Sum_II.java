package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_Combination_Sum_II {
    int[] candidates;
    int target;
    List<List<Integer>> res;
    List<Integer> list;
    // Time: O(n * 2^n)
    // Space: O(2^n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        process(0, 0);
        return res;
    }

    private void process(int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
        }
        if (index == candidates.length) return;
        if (sum > target) return;


        // include index
        list.add(candidates[index]);
        process(index + 1, sum + candidates[index]);
        list.remove(list.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        process(index + 1, sum);
    }

    public static void main(String[] args) {
        _40_Combination_Sum_II s = new _40_Combination_Sum_II();
        System.out.println(s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }


}
