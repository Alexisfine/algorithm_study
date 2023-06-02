package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _39_Combination_Sum {
    int[] candidates;
    int target;
    List<List<Integer>> res;
    // Time: O(n * 2^n)
    // Space: O(2^n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        this.res = new ArrayList<>();
        process(0, 0, new ArrayList<>());
        return res;
    }

    private void process(int index, int currentSum, List<Integer> list) {
        // base case
        if (currentSum == target) {
            res.add(list);
            return;
        }

        if (index == candidates.length) return;
        if (currentSum > target) return;

        for (int i = 0; currentSum + candidates[index] * i <= target; i++) {
            List<Integer> newList = new ArrayList<>(list);
            for (int j = 0; j < i; j++) newList.add(candidates[index]);
            process(index + 1, currentSum + i * candidates[index], newList);
        }
    }

    public static void main(String[] args) {
        _39_Combination_Sum s = new _39_Combination_Sum();
        System.out.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
