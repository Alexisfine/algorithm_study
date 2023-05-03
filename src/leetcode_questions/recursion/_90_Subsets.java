package leetcode_questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        process(nums, 0, new ArrayList<>(), list);
        return list;
    }

    private void process(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (nums.length == index) {
            result.add(current);
            return;
        }
        List<Integer> excludeI = new ArrayList<>();
        process(nums, index + 1, excludeI, result);
        int size = current.size();
        List<Integer> includeI = new ArrayList<>(List.copyOf(current));
        includeI.add(nums[index]);
        process(nums, index + 1, includeI, result);
    }
}
