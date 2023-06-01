package leetcode_questions.backtracking;

import java.util.*;

public class _47_Permutations_II {
    int[] nums;
    List<List<Integer>> res;
    List<Integer> list;
    HashMap<Integer, Integer> map;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        process(0);
        return res;
    }

    private void process(int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();
            int count = (int) entry.getValue();
            if (count <= 0) continue;
            map.put(key, count - 1);
            list.add(key);
            process(index + 1);
            list.remove(list.size() - 1);
            map.put(key, count);
        }
    }
}
