package leetcode_questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class _39_Combination_Sum {
    // Time: O(n * 2^n)
    // Space: O(2^n)
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        process(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    private static void process(int[] candidates, int target, int currentVal,
                                int currentSum, List<List<Integer>> res, List<Integer> cur) {
        // base case
        if (currentSum == target) {
            res.add(cur);
            return;
        }
        if (currentVal == candidates.length) return;
        if (currentSum > target) return;

        for (int i = 0; i * candidates[currentVal] + currentSum <= target; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(cur);
            for (int j = 0; j < i; j++) list.add(candidates[currentVal]);
            process(
                    candidates,
                    target,
                    currentVal + 1,
                    currentSum + i * candidates[currentVal],
                    res,
                    list
            );
        }
    }
}
