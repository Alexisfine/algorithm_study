package leetcode_questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_Combination_Sum_II {
    // Time: O(n * 2^n)
    // Space: O(2^n)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) return res;
        Arrays.sort(candidates);
        process(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void process(int[] candidates, int target, int start,
                                List<Integer> list, List<List<Integer>> res) {
        // base case
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            process(candidates, target - candidates[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }


    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
