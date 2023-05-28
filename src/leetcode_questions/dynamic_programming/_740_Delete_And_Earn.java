package leetcode_questions.dynamic_programming;

import java.util.*;

import static java.util.Arrays.*;

public class _740_Delete_And_Earn {
    public static int deleteAndEarn(int[] nums) {
        if (nums == null) return 0;
        int N = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(nums[i]);
        return dfs(nums, 0, set);
    }

    private static int dfs(int[] nums, int index, Set<Integer> set) {
        if (index >= nums.length) return 0;
        int skip = dfs(nums, index + 1, set);

        int notSkip = 0;
        if (set.contains(nums[index])) {
            boolean r1 = set.contains(nums[index] - 1);
            boolean r2 = set.contains(nums[index] + 1);
            set.remove(nums[index] - 1);
            set.remove(nums[index] + 1);
            notSkip = dfs(nums, index + 1, set) + nums[index];
            if (r1) set.add(nums[index] - 1);
            if (r2) set.add(nums[index] + 1);
        }

        return Math.max(skip, notSkip);
    }

    // Time: O(N * logN)
    // Space: O(K)
    public static int deleteAndEarn2(int[] nums) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(nums[i]);
        ArrayList<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());

        int first = 0;
        int second = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i - 1) + 1 == list.get(i)) {
                int temp = Math.max(second, first + map.get(list.get(i)) * list.get(i));
                first = second;
                second = temp;
            } else {
                int temp = second + first + map.get(list.get(i)) * list.get(i);
                first = second;
                second = temp;
            }
        }
        return second;
    }
}
