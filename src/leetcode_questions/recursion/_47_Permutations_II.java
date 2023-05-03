package leetcode_questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_Permutations_II {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        Arrays.sort(nums);
        process(nums, 0, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private static void process(int[] nums, int current, boolean[] used,
                                List<Integer> list, List<List<Integer>> res) {
        if (current == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = current; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            swap(nums, i, current);
            list.add(nums[current]);
            process(nums, current + 1, used, list, res);
            swap(nums, i, current);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,2,3}));
    }
}
