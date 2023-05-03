package leetcode_questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        process(nums, 0, new ArrayList<>(), l);
        return l;
    }

    private void process(int[] nums, int i, List<Integer> list, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(list);
            return;
        }
        List<Integer> includeI = new ArrayList<>(List.copyOf(list));
        includeI.add(nums[i]);
        process(nums, i + 1, includeI, result);
        List<Integer> excludeI = new ArrayList<>();
        process(nums, i + 1, excludeI, result);
    }
}
