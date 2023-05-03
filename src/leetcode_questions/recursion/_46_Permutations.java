package leetcode_questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    // Time: O(n!)
    // Space: O(n!)
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void process(int[] nums, int cur, List<Integer> list, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = cur; i < nums.length; i++) {
            swap(nums, cur, i);
            list.add(nums[cur]);
            process(nums, cur + 1, list, res);
            swap(nums, cur, i);
            list.remove(list.size() - 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
