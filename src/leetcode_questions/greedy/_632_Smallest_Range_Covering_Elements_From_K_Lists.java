package leetcode_questions.greedy;

import java.util.List;
import java.util.TreeSet;

public class _632_Smallest_Range_Covering_Elements_From_K_Lists {
    private record Pair(int value, int groupId) {}
    public int[] smallestRange(List<List<Integer>> nums) {
        int N = nums.size();
        int[] pointers = new int[N];
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.value != b.value) return a.value - b.value;
            return a.groupId - b.groupId;
            }
        );
        for (int i = 0; i < N; i++) {
            set.add(new Pair(nums.get(i).get(0), i));
        }
        int range = Integer.MAX_VALUE;
        int[] res = new int[]{0, 0};
        while (true) {
            if (set.last().value - set.first().value < range) {
                res[0] = set.first().value;
                res[1] = set.last().value;
                range = res[1] - res[0];
            }
            int groupId = set.first().groupId;
            pointers[groupId]++;
            set.remove(set.first());
            if (pointers[groupId] == nums.get(groupId).size()) break;
            set.add(new Pair(nums.get(groupId).get(pointers[groupId]), groupId));

        }
        return res;
    }
}
